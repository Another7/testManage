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
import org.springframework.web.bind.annotation.RequestParam;
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
public class ManageController {

	@Autowired
	private KnowledgePointService knowledgePointService;
	
	@Autowired
	private ChapterService chapterService;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private SubjectService subjectService;
	
	//根据章节id查询该章节下的所有知识点
	@RequestMapping(value = "/getKnowledgePointByCt_id.action",method = RequestMethod.GET)
	public String getKnowledgePointByCt_id(HttpServletRequest request,String ct_id,String ct_c_id,Model model ){
		
		System.out.println("ctId:"+ct_id);
		List<KnowledgePoint> list=knowledgePointService.getKnowledgePointByCt_id(Integer.valueOf(ct_id));
		System.out.println("getKnowledgePointService:"+list.toString());
		model.addAttribute("knowledgePoint",list);
		model.addAttribute("ct_id",ct_id);
		model.addAttribute("ct_c_id",ct_c_id);
		return "KnowledgePoint";
	}
	
	
	
	//添加知识点
	@RequestMapping(value = "/addknowledgePoint.action",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> addKnowledgePoint(@RequestBody KnowledgePoint knowledgePoint){
		Map<String, String> map=new HashMap<String, String>();
		System.out.println(knowledgePoint.toString());
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
		
		//查询出subject列表放入session
		List<Subject> subjectList=subjectService.getAllSubjects();
		//将科目类别写入session	
		request.getSession().setAttribute("SUBJECTS_SESSION", subjectList);
		
		model.addAttribute("Courses", courses);
		return "KnowledgePointManage";
		
	}
	
	
	/*根据课程的id所有的章节*/
	@RequestMapping(value = "/getChapterByCid.action",method = RequestMethod.GET)
	public String getChapters(HttpServletRequest request,String c_id,Model model){
		//String c_id=request.getParameter("c_id");
		System.out.println(c_id);
		
		System.out.println("getChapter:"+c_id);
		
		List<ChapterTitle> list=chapterService.getChapterByCid(String.valueOf(c_id));
		model.addAttribute("Chapter",list);
		model.addAttribute("c_id",c_id);
		
		System.out.println("CourseList:"+list.toString());
		return "ChapterManage";
		
	}
	
	//新建章节（单个）
	@RequestMapping(value = "/addChapter.action")
	@ResponseBody
	public Map<String,String> addChapters( @RequestBody ChapterData chapter){
		//String c_id=request.getParameter("c_id");
		String c_id=chapter.getC_id();//获取章节id
		String ct_name=chapter.getCt_name();
		 Map<String, String> map=new HashMap<String, String>();
		System.out.println("111:"+c_id);
		System.out.println("addChapters222:"+ct_name);
		
		boolean result=chapterService.addChapter(Integer.valueOf(c_id),ct_name);
		if(result){
			map.put("result", "yes");
		}else{
			map.put("result", "no");
		}	
		return map;
		
	}

	
	@RequestMapping(value = "/deleteCourse.action")
	@ResponseBody
	//根据课程id删除课程
	public Map<String,String> deleteCourse(int c_id){
		Map<String, String> map=new HashMap<String, String>();
		map.put("status_code",String.valueOf(courseService.deleteCourse(c_id)));
		return map;
	}
	
	
	@RequestMapping(value = "/getChapterById.action")
	@ResponseBody
	//根据章节id获取章节
	public String getChapterById(HttpServletRequest request,Model model){
		int ct_id = (int) request.getAttribute("ct_id");
		model.addAttribute("chapterTitle", chapterService.getChapterById(ct_id));
		return "chapterManager";
	}
	
	
	
}
