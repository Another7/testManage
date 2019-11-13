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

import com.test.po.Subject;
import com.test.pojo.QuestionLevelNumber;
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
	@RequestMapping(value = "/createTestPaper.action")
	public String getCourses(HttpServletRequest request, Model model) {

		List<Subject> subjectList = subjectService.getAllSubjects();
		// ����Ŀ���д��session
		request.getSession().setAttribute("SUBJECTS_SESSION", subjectList);

		return "CreateTestPaper";

	}

	// �����½�id��ȡ��ͬ��������Ĳ�ͬ�ȼ�������
	// ���磺��ѡ�⣺�򵥵��ж��ٵ��⣬���׵��ж��ٵ��⡣
	@RequestMapping(value = "/questionLevelNumber")
	public Map<String, QuestionLevelNumber> getQuestionLevelNumber(@RequestBody String[] chapterIds) {
		List<Integer> chapterIdList = new ArrayList<Integer>();
		for (String chapterId : chapterIds) {
			Integer id = Integer.parseInt(chapterId);
			chapterIdList.add(id);
		}
		return questionService.countQuestionLevelNumber(chapterIdList);
	}

}
