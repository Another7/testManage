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
import com.test.service.ChapterService;
import com.test.service.CourseService;
import com.test.service.KnowledgePointService;

@Controller
public class ManageController {

	@Autowired
	private KnowledgePointService knowledgePointService;
	private ChapterService chapterService;
	
	@Autowired
	private CourseService courseService;
	
	//根据章节id查询该章节下的所有知识点
	@RequestMapping(value = "/getKnowledgePointByCt_id.action",method = RequestMethod.POST)
	@ResponseBody
	public List<KnowledgePoint> getKnowledgePointByCt_id(int ct_id){
		return knowledgePointService.getKnowledgePointByCt_id(ct_id);
	}
	
	
	
	//添加知识点
	@RequestMapping(value = "/addKnowledgePoint.action",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> addKnowledgePoint(@RequestBody KnowledgePoint knowledgePoint){
		Map<String, String> map=new HashMap<String, String>();
		int status_code = knowledgePointService.addKnowledgePoint(knowledgePoint);
		map.put("status_code",String.valueOf(status_code));
		return map;
	}
	
	
	
	//删除知识点
	@RequestMapping(value = "/deleteKnowledgePointByKp_id.action",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> deleteKnowledgePointByKp_id(int kp_id){
		
		Map<String, String> map=new HashMap<String, String>();
		int status_code = knowledgePointService.deleteKnowledgePointByKp_id(kp_id);
		map.put("status_code",String.valueOf(status_code));
		return map;
		
	}
	
	
	//修改章节
	@RequestMapping(value = "/updateChapter.action",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> updateChapter(@RequestBody ChapterTitle chapterTitle){
		
		Map<String, String> map=new HashMap<String, String>();
		int status_code = chapterService.updateChapter(chapterTitle);
		map.put("status_code",String.valueOf(status_code));
		return map;
		
	}
	
	
	//删除章节
	@RequestMapping(value = "/deleteChapterByCid.action",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> deleteChapterByCid(int ct_id){
		
		Map<String, String> map=new HashMap<String, String>();
		int status_code = chapterService.deleteChapterByCid(ct_id);
		map.put("status_code",String.valueOf(status_code));
		return map;
		
	}
	
	//获取所有的课程列表
	@RequestMapping(value = "/getAllCourses.action",method = RequestMethod.GET)
	public String getCourses(HttpServletRequest request,Model model){
		
	//	System.out.println(courseService==null);
		List<Course> courses=courseService.getAllCourses();
		
		
		model.addAttribute("Courses", courses);
		return "KnowledgePointManage";
		
	}
	
	
	
	
	
	
}
