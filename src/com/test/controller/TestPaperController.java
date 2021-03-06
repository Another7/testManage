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
		
		System.out.println("testPaperData:"+testPaperData.toString());
		
		// System.out.println("111:"+c_id);
		// System.out.println("addChapters222:"+ct_name);
		TestPaper testPaper = testPaperService.randomCreateTestPaper(testPaperData);
		boolean result = testPaperService.insertTestPaper(testPaper) > 0;
		
		String tpId=testPaper.getTp_id().toString();
		System.out.println("1111:"+tpId);
		map.put("tpId", tpId);
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
	public String createTestPaper(String tpId, Model model) {
		System.out.println("tpId:"+tpId);
		TestPaper testPaper = testPaperService.selectTestPaperById(Integer.parseInt(tpId));
		TestPaperView testPaperView = testPaperService.convertTestPaper(testPaper);
		
		System.out.println(testPaperView.toString());
		model.addAttribute("tpId",tpId);
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
}
