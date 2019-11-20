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

	// ת���������Ծ�ҳ��
	@RequestMapping(value = "/toCreateTestPaper.action")
	public String getCourses(HttpServletRequest request, Model model) {

		List<Subject> subjectList = subjectService.getAllSubjects();
		// ����Ŀ���д��session
		request.getSession().setAttribute("SUBJECTS_SESSION", subjectList);

		return "CreateTestPaper";

	}

	// �����½�id��ȡ��ͬ��������Ĳ�ͬ�ȼ�������
	// ���磺��ѡ�⣺�򵥵��ж��ٵ��⣬���׵��ж��ٵ��⡣
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

	// �����Ծ���������ɹ������Ծ�id
	@RequestMapping(value = "/createTestPaper.action", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> createTestPaper(@RequestBody TestPaperData testPaperData) {

		/*
		 * String tpName; String tpIllustrate; private String tpTerm; private String
		 * tpClass; private QuestionLevelNumber scNumber; private QuestionLevelNumber
		 * mcNumber; private QuestionLevelNumber fbNumber; private QuestionLevelNumber
		 * tfNumber;
		 */

		// map����Ծ��Ƿ񴴽��ɹ�������ɹ������Ծ�������ݿ⣬�����Ծ�id�����ʧ��ֻ����ʧ����Ϣ
		Map<String, String> map = new HashMap<String, String>();
		// System.out.println("111:"+c_id);
		// System.out.println("addChapters222:"+ct_name);
		TestPaper testPaper = testPaperService.randomCreateTestPaper(testPaperData);
		boolean result = testPaperService.insertTestPaper(testPaper) > 0;
		map.put("tpId", testPaper.getTp_id().toString());
		// �Ծ��Ƿ����ɹ�
		if (result) {
			map.put("result", "yes");
		} else {
			map.put("result", "no");
		}
		return map;
	}

	// �����Ծ�id��ȡ�Ծ�view����(�ŵ�model��)
	@RequestMapping(value = "/getTestPaperByTpid.action", method = RequestMethod.GET)
	@ResponseBody
	public String createTestPaper(String tpId, Model model) {
		TestPaper testPaper = testPaperService.selectTestPaperById(Integer.parseInt(tpId));
		TestPaperView testPaperView = testPaperService.convertTestPaper(testPaper);
		model.addAttribute("testPaperView", testPaperView);
		return "TestPaperView";// ת����TestPaperView
	}

	// �����Ծ�id�����Ծ�
	@RequestMapping(value = "/exportTestPaper.action", method = RequestMethod.GET)
	@ResponseBody
	public void exportTestPaper(HttpServletRequest request, HttpServletResponse response, String tpId)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		TestPaper testPaper = testPaperService.selectTestPaperById(Integer.parseInt(tpId));
		Map<String, Object> dataMap = testPaperService.dataFill(testPaper);
//		getFillData(dataMap);
//		��ʵ�������
		String basePath = System.getProperty("user.dir");
		String targetPath = basePath + File.separator + "demo.docx";
		ExportWordUtil.createWord(dataMap, targetPath);

		File file = null;
		InputStream fin = null;
		ServletOutputStream out = null;
		try {
			// ���ù�����WordUtils��createDoc��������Word�ĵ�
			file = new File(targetPath);
			fin = new FileInputStream(file);
			response.setCharacterEncoding("utf-8");
			response.setContentType("application/msword");
			// ��������������صķ�ʽ������ļ�Ĭ����Ϊdemo.doc
			response.setHeader("content-disposition",
					"attachment;filename=" + URLEncoder.encode("demo" + ".doc", "UTF-8"));
			out = response.getOutputStream();
			byte[] buffer = new byte[512]; // ������
			int bytesToRead = -1;
			// ͨ��ѭ���������Word�ļ�������������������
			while ((bytesToRead = fin.read(buffer)) != -1) {
				out.write(buffer, 0, bytesToRead);
			}
		} finally {
			if (fin != null)
				fin.close();
			if (out != null)
				out.close();
			if (file != null)
				file.delete(); // ɾ����ʱ�ļ�
		}
	}
	
	private static void getFillData(Map<String, Object> dataMap) {
		// ����ģ���еĲ���������ݣ����Բ���˳�򣬲�������Ҫ����
		// �Ծ������Ϣ
		dataMap.put("schoolName", "��ԭ��ѧԺ");
		dataMap.put("startYear", "2016");
		dataMap.put("endYear", "2017");
		dataMap.put("semester", "1");
		dataMap.put("class", "׿Խ161");
		// ƴ����������п��Ի�����ĩ����
		dataMap.put("testPaperName", "��������� ��ĩ�Ծ�");
		dataMap.put("major", "�������");
		dataMap.put("marker", "another");
		// ��ѡ��
		SingleChoice singleChoice = new SingleChoice();
		singleChoice.setContent("��ϲ����һ��()");
		singleChoice.setOptionA("��һ��");
		singleChoice.setOptionB("�ڶ���");
		singleChoice.setOptionC("������");
		singleChoice.setOptionD("������");
		List<SingleChoice> singleChoiceList = new ArrayList<SingleChoice>();
		singleChoiceList.add(singleChoice);
		dataMap.put("singleChoiceList", singleChoiceList);
		
		// ��ѡ��
		MultipleChoice multipleChoice = new MultipleChoice();
		multipleChoice.setContent("��ϲ����ʲô()");
		multipleChoice.setOptionA("�㽶");
		multipleChoice.setOptionB("����");
		multipleChoice.setOptionC("����");
		multipleChoice.setOptionD("����");
		List<MultipleChoice> multipleChoiceList = new ArrayList<MultipleChoice>();
		multipleChoiceList.add(multipleChoice);
		MultipleChoice multipleChoice1 = new MultipleChoice();
		multipleChoice1.setContent("��ϲ����ʲô()");
		multipleChoice1.setOptionA("����");
		multipleChoice1.setOptionB("ѩ��");
		multipleChoice1.setOptionC("ţ��");
		multipleChoice1.setOptionD("�̲�");
		multipleChoiceList.add(multipleChoice1);
		dataMap.put("multipleChoiceList", multipleChoiceList);
		
		// �����
		FillInTheBlank fillInTheBlank = new FillInTheBlank();
		fillInTheBlank.setContent("��õı��������____.");
		FillInTheBlank fillInTheBlank1 = new FillInTheBlank();
		fillInTheBlank1.setContent("��õĲ���ϵͳ��____.");
		FillInTheBlank fillInTheBlank2 = new FillInTheBlank();
		fillInTheBlank2.setContent("��õ��ֻ�Ʒ����____.");
		List<FillInTheBlank> fillInTheBlankList = new ArrayList<FillInTheBlank>();
		fillInTheBlankList.add(fillInTheBlank);
		fillInTheBlankList.add(fillInTheBlank1);
		fillInTheBlankList.add(fillInTheBlank2);
		dataMap.put("fillInTheBlankList", fillInTheBlankList);
		
		// �ж���
		TrueOrFalse trueOrFalse = new TrueOrFalse();
		trueOrFalse.setContent("PHP����������õı������");
		TrueOrFalse trueOrFalse1 = new TrueOrFalse();
		trueOrFalse1.setContent("Java����������õı������");
		TrueOrFalse trueOrFalse2 = new TrueOrFalse();
		trueOrFalse2.setContent("Python����������õı������");
		List<TrueOrFalse> trueOrFalseList = new ArrayList<TrueOrFalse>();
		trueOrFalseList.add(trueOrFalse);
		trueOrFalseList.add(trueOrFalse1);
		trueOrFalseList.add(trueOrFalse2);
		dataMap.put("trueOrFalseList", trueOrFalseList);
		
		// �ʴ���
		QuestionAndAnswer questionAndAnswer = new QuestionAndAnswer();
		questionAndAnswer.setContent("����HTTP�������ֹ���");
		QuestionAndAnswer questionAndAnswer1 = new QuestionAndAnswer();
		questionAndAnswer1.setContent("�����������");
		QuestionAndAnswer questionAndAnswer2 = new QuestionAndAnswer();
		questionAndAnswer2.setContent("���ʹ�ðٶ���������");
		List<QuestionAndAnswer> questionAndAnswerList = new ArrayList<QuestionAndAnswer>();
		questionAndAnswerList.add(questionAndAnswer);
		questionAndAnswerList.add(questionAndAnswer1);
		questionAndAnswerList.add(questionAndAnswer2);
		dataMap.put("questionAndAnswerList", questionAndAnswerList);
		
	}

}
