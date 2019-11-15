package com.test.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.po.Subject;
import com.test.pojo.QuestionLevelNumber;
import com.test.pojo.TestPaperData;
import com.test.service.ChapterService;
import com.test.service.CourseService;
import com.test.service.KnowledgePointService;
import com.test.service.QuestionService;
import com.test.service.SubjectService;

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
	@RequestMapping(value = "/questionLevelNumber.action",method = RequestMethod.POST)
	@ResponseBody
	public Map<String, QuestionLevelNumber> getQuestionLevelNumber(@RequestParam(value = "data")String[] data ) {
		List<Integer> chapterIdList = new ArrayList<Integer>();
		for (String chapterId : data) {
			Integer id = Integer.parseInt(chapterId);
			chapterIdList.add(id);
		}
		//scQuestionNumber		level1	level2	level3	level4
		//mcQuestionNumber		
		//tfQuestionNumber
		//fbQuestionNumber
		//qaQuestionNumber
		
		return questionService.countQuestionLevelNumber(chapterIdList);
	}
	//�����Ծ���������ɹ������Ծ�
		@RequestMapping(value = "/createTestPaper.action",method = RequestMethod.POST)
		@ResponseBody
		public TestPaperData createTestPaper(@RequestBody TestPaperData testPaperData) {
			
			/* String tpName;
		 	String tpIllustrate;
			private String tpTerm;
			private String tpClass;
			private QuestionLevelNumber scNumber;
			private QuestionLevelNumber mcNumber;
			private QuestionLevelNumber fbNumber;
			private QuestionLevelNumber tfNumber;*/
			
			return null;
		}

}
