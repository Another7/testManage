package com.test.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.po.ChapterTitle;
import com.test.po.Course;
import com.test.po.KnowledgePoint;
import com.test.po.Subject;
import com.test.pojo.ChapterData;
import com.test.service.ChapterService;
import com.test.service.CourseService;
import com.test.service.KnowledgePointService;
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
	
	
	//转发到创建试卷页面
	@RequestMapping(value = "/createTestPaper.action")
	public String getCourses(HttpServletRequest request,Model model){
		
		List<Subject> subjectList=subjectService.getAllSubjects();
		//将科目类别写入session	
		request.getSession().setAttribute("SUBJECTS_SESSION", subjectList);
		
		return "CreateTestPaper";
		
	}
	
	
}
