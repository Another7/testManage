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
	//创建试卷，如果创建成功返回试卷
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
