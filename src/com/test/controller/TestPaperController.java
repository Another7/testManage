package com.test.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.po.Subject;
import com.test.po.TestPaper;
import com.test.po.TestPaperView;
import com.test.pojo.FillInTheBlank;
import com.test.pojo.MultipleChoice;
import com.test.pojo.QuestionAndAnswer;
import com.test.pojo.QuestionLevelNumber;
import com.test.pojo.SingleChoice;
import com.test.pojo.TestPaperData;
import com.test.pojo.TrueOrFalse;
import com.test.service.ChapterService;
import com.test.service.CourseService;
import com.test.service.KnowledgePointService;
import com.test.service.QuestionService;
import com.test.service.SubjectService;
import com.test.service.TestPaperService;
import com.test.util.ExportWordUtil;

@Controller
public class TestPaperController {

	@Autowired
	private KnowledgePointService knowledgePointService;

	@Autowired
	private ChapterService chapterService;

	@Autowired
	private CourseService courseService;

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private TestPaperService testPaperService;

	// 转发到创建试卷页面
	@RequestMapping(value = "/toCreateTestPaper.action")
	public String getCourses(HttpServletRequest request, Model model) {

		List<Subject> subjectList = subjectService.getAllSubjects();
		// 将科目类别写入session
		request.getSession().setAttribute("SUBJECTS_SESSION", subjectList);

		return "CreateTestPaper";

	}

	// 根据章节id获取不同类型问题的不同等级的数量
	// 例如：单选题：简单的有多少道题，容易的有多少道题。
	@RequestMapping(value = "/questionLevelNumber.action", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, QuestionLevelNumber> getQuestionLevelNumber(@RequestParam(value = "data") String[] data) {
		List<Integer> chapterIdList = new ArrayList<Integer>();
		for (String chapterId : data) {
			Integer id = Integer.parseInt(chapterId);
			chapterIdList.add(id);
		}
		// scQuestionNumber level1 level2 level3 level4
		// mcQuestionNumber
		// tfQuestionNumber
		// fbQuestionNumber
		// qaQuestionNumber

		return questionService.countQuestionLevelNumber(chapterIdList);
	}

	// 创建试卷，如果创建成功返回试卷id
	@RequestMapping(value = "/createTestPaper.action", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> createTestPaper(@RequestBody TestPaperData testPaperData) {

		/*
		 * String tpName; String tpIllustrate; private String tpTerm; private String
		 * tpClass; private QuestionLevelNumber scNumber; private QuestionLevelNumber
		 * mcNumber; private QuestionLevelNumber fbNumber; private QuestionLevelNumber
		 * tfNumber;
		 */

		// map存放试卷是否创建成功，如果成功，将试卷插入数据库，返回试卷id，如果失败只返回失败消息
		Map<String, String> map = new HashMap<String, String>();
		// System.out.println("111:"+c_id);
		// System.out.println("addChapters222:"+ct_name);
		TestPaper testPaper = testPaperService.randomCreateTestPaper(testPaperData);
		boolean result = testPaperService.insertTestPaper(testPaper) > 0;
		map.put("tpId", testPaper.getTp_id().toString());
		// 试卷是否插入成功
		if (result) {
			map.put("result", "yes");
		} else {
			map.put("result", "no");
		}
		return map;
	}

	// 根据试卷id获取试卷view对象(放到model中)
	@RequestMapping(value = "/getTestPaperByTpid.action", method = RequestMethod.GET)
	@ResponseBody
	public String createTestPaper(String tpId, Model model) {
		TestPaper testPaper = testPaperService.selectTestPaperById(Integer.parseInt(tpId));
		TestPaperView testPaperView = testPaperService.convertTestPaper(testPaper);
		model.addAttribute("testPaperView", testPaperView);
		return "TestPaperView";// 转发到TestPaperView
	}

	// 根据试卷id导出试卷
	@RequestMapping(value = "/exportTestPaper.action", method = RequestMethod.GET)
	@ResponseBody
	public void exportTestPaper(HttpServletRequest request, HttpServletResponse response, String tpId)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		TestPaper testPaper = testPaperService.selectTestPaperById(Integer.parseInt(tpId));
		Map<String, Object> dataMap = testPaperService.dataFill(testPaper);
//		getFillData(dataMap);
//		真实数据填充
		String basePath = System.getProperty("user.dir");
		String targetPath = basePath + File.separator + "demo.docx";
		ExportWordUtil.createWord(dataMap, targetPath);

		File file = null;
		InputStream fin = null;
		ServletOutputStream out = null;
		try {
			// 调用工具类WordUtils的createDoc方法生成Word文档
			file = new File(targetPath);
			fin = new FileInputStream(file);
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/msword");
			// 设置浏览器以下载的方式处理该文件默认名为demo.doc
			response.setHeader("content-disposition",
					"attachment;filename=" + URLEncoder.encode("demo" + ".doc", "UTF-8"));
			out = response.getOutputStream();
			byte[] buffer = new byte[512]; // 缓冲区
			int bytesToRead = -1;
			// 通过循环将读入的Word文件的内容输出到浏览器中
			while ((bytesToRead = fin.read(buffer)) != -1) {
				out.write(buffer, 0, bytesToRead);
			}
		} finally {
			if (fin != null)
				fin.close();
			if (out != null)
				out.close();
			if (file != null)
				file.delete(); // 删除临时文件
		}
	}
	
	private static void getFillData(Map<String, Object> dataMap) {
		// 根据模板中的参数填充内容，可以不按顺序，参数名称要对上
		// 试卷基本信息
		dataMap.put("schoolName", "中原工学院");
		dataMap.put("startYear", "2016");
		dataMap.put("endYear", "2017");
		dataMap.put("semester", "1");
		dataMap.put("class", "卓越161");
		// 拼接添加是期中考试还是期末考试
		dataMap.put("testPaperName", "计算机网络 期末试卷");
		dataMap.put("major", "软件工程");
		dataMap.put("marker", "another");
		// 单选题
		SingleChoice singleChoice = new SingleChoice();
		singleChoice.setContent("你喜欢哪一行()");
		singleChoice.setOptionA("第一行");
		singleChoice.setOptionB("第二行");
		singleChoice.setOptionC("第三行");
		singleChoice.setOptionD("第四行");
		List<SingleChoice> singleChoiceList = new ArrayList<SingleChoice>();
		singleChoiceList.add(singleChoice);
		dataMap.put("singleChoiceList", singleChoiceList);
		
		// 多选题
		MultipleChoice multipleChoice = new MultipleChoice();
		multipleChoice.setContent("你喜欢吃什么()");
		multipleChoice.setOptionA("香蕉");
		multipleChoice.setOptionB("柚子");
		multipleChoice.setOptionC("麻油");
		multipleChoice.setOptionD("鸡蛋");
		List<MultipleChoice> multipleChoiceList = new ArrayList<MultipleChoice>();
		multipleChoiceList.add(multipleChoice);
		MultipleChoice multipleChoice1 = new MultipleChoice();
		multipleChoice1.setContent("你喜欢喝什么()");
		multipleChoice1.setOptionA("可乐");
		multipleChoice1.setOptionB("雪碧");
		multipleChoice1.setOptionC("牛奶");
		multipleChoice1.setOptionD("奶茶");
		multipleChoiceList.add(multipleChoice1);
		dataMap.put("multipleChoiceList", multipleChoiceList);
		
		// 填空题
		FillInTheBlank fillInTheBlank = new FillInTheBlank();
		fillInTheBlank.setContent("最好的编程语言是____.");
		FillInTheBlank fillInTheBlank1 = new FillInTheBlank();
		fillInTheBlank1.setContent("最好的操作系统是____.");
		FillInTheBlank fillInTheBlank2 = new FillInTheBlank();
		fillInTheBlank2.setContent("最好的手机品牌是____.");
		List<FillInTheBlank> fillInTheBlankList = new ArrayList<FillInTheBlank>();
		fillInTheBlankList.add(fillInTheBlank);
		fillInTheBlankList.add(fillInTheBlank1);
		fillInTheBlankList.add(fillInTheBlank2);
		dataMap.put("fillInTheBlankList", fillInTheBlankList);
		
		// 判断题
		TrueOrFalse trueOrFalse = new TrueOrFalse();
		trueOrFalse.setContent("PHP是世界上最好的编程语言");
		TrueOrFalse trueOrFalse1 = new TrueOrFalse();
		trueOrFalse1.setContent("Java是世界上最好的编程语言");
		TrueOrFalse trueOrFalse2 = new TrueOrFalse();
		trueOrFalse2.setContent("Python是世界上最好的编程语言");
		List<TrueOrFalse> trueOrFalseList = new ArrayList<TrueOrFalse>();
		trueOrFalseList.add(trueOrFalse);
		trueOrFalseList.add(trueOrFalse1);
		trueOrFalseList.add(trueOrFalse2);
		dataMap.put("trueOrFalseList", trueOrFalseList);
		
		// 问答题
		QuestionAndAnswer questionAndAnswer = new QuestionAndAnswer();
		questionAndAnswer.setContent("简述HTTP三次握手过程");
		QuestionAndAnswer questionAndAnswer1 = new QuestionAndAnswer();
		questionAndAnswer1.setContent("如何求矩阵的逆");
		QuestionAndAnswer questionAndAnswer2 = new QuestionAndAnswer();
		questionAndAnswer2.setContent("如何使用百度搜索引擎");
		List<QuestionAndAnswer> questionAndAnswerList = new ArrayList<QuestionAndAnswer>();
		questionAndAnswerList.add(questionAndAnswer);
		questionAndAnswerList.add(questionAndAnswer1);
		questionAndAnswerList.add(questionAndAnswer2);
		dataMap.put("questionAndAnswerList", questionAndAnswerList);
		
	}

}
