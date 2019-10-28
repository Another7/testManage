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
	
	//�����½�id��ѯ���½��µ�����֪ʶ��
	@RequestMapping(value = "/getKnowledgePointByCt_id.action",method = RequestMethod.POST)
	@ResponseBody
	public List<KnowledgePoint> getKnowledgePointByCt_id(int ct_id){
		return knowledgePointService.getKnowledgePointByCt_id(ct_id);
	}
	
	
	
	//���֪ʶ��
	@RequestMapping(value = "/addKnowledgePoint.action",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> addKnowledgePoint(@RequestBody KnowledgePoint knowledgePoint){
		Map<String, String> map=new HashMap<String, String>();
		int status_code = knowledgePointService.addKnowledgePoint(knowledgePoint);
		map.put("status_code",String.valueOf(status_code));
		return map;
	}
	
	
	
	//ɾ��֪ʶ��
	@RequestMapping(value = "/deleteKnowledgePointByKp_id.action",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> deleteKnowledgePointByKp_id(int kp_id){
		
		Map<String, String> map=new HashMap<String, String>();
		int status_code = knowledgePointService.deleteKnowledgePointByKp_id(kp_id);
		map.put("status_code",String.valueOf(status_code));
		return map;
		
	}
	
	
	//�޸��½�
	@RequestMapping(value = "/updateChapter.action",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> updateChapter(@RequestBody ChapterTitle chapterTitle){
		
		Map<String, String> map=new HashMap<String, String>();
		int status_code = chapterService.updateChapter(chapterTitle);
		map.put("status_code",String.valueOf(status_code));
		return map;
		
	}
	
	
	//ɾ���½�
	@RequestMapping(value = "/deleteChapterByCid.action",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> deleteChapterByCid(int ct_id){
		
		Map<String, String> map=new HashMap<String, String>();
		int status_code = chapterService.deleteChapterByCid(ct_id);
		map.put("status_code",String.valueOf(status_code));
		return map;
		
	}
	
	//��ȡ���еĿγ��б�
	@RequestMapping(value = "/getAllCourses.action",method = RequestMethod.GET)
	public String getCourses(HttpServletRequest request,Model model){
		
	//	System.out.println(courseService==null);
		List<Course> courses=courseService.getAllCourses();
		
		
		model.addAttribute("Courses", courses);
		return "KnowledgePointManage";
		
	}
	
	
	
	
	
	
}
