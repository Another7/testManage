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
		
		System.out.println("testPaperData:"+testPaperData.toString());
		
		// System.out.println("111:"+c_id);
		// System.out.println("addChapters222:"+ct_name);
		TestPaper testPaper = testPaperService.randomCreateTestPaper(testPaperData);
		boolean result = testPaperService.insertTestPaper(testPaper) > 0;
		
		String tpId=testPaper.getTp_id().toString();
		System.out.println("1111:"+tpId);
		map.put("tpId", tpId);
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
	public String createTestPaper(String tpId, Model model) {
		System.out.println("tpId:"+tpId);
		TestPaper testPaper = testPaperService.selectTestPaperById(Integer.parseInt(tpId));
		TestPaperView testPaperView = testPaperService.convertTestPaper(testPaper);
		
		System.out.println(testPaperView.toString());
		model.addAttribute("tpId",tpId);
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
}
