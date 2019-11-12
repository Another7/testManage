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
	
	//�����½�id��ѯ���½��µ�����֪ʶ��
	@RequestMapping(value = "/getKnowledgePointByCt_id.action",method = RequestMethod.GET)
	public List<KnowledgePoint> getKnowledgePointByCt_id(HttpServletRequest request,String ct_id,Model model ){
		
		System.out.println("ctId:"+ct_id);
		List<KnowledgePoint> list=knowledgePointService.getKnowledgePointByCt_id(Integer.valueOf(ct_id));
		System.out.println("getKnowledgePointService:"+list.toString());
		//model.addAttribute("knowledgePoint",list);
		model.addAttribute("ct_id",ct_id);
		//model.addAttribute("ct_c_id",ct_c_id);
		return list;
	}
	
	
	
	//���֪ʶ��
	@RequestMapping(value = "/addknowledgePoint.action",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> addKnowledgePoint(@RequestBody KnowledgePoint knowledgePoint){
		Map<String, String> map=new HashMap<String, String>();
		System.out.println(knowledgePoint.toString());
		int status_code = knowledgePointService.addKnowledgePoint(knowledgePoint);
		map.put("status_code",String.valueOf(status_code));
		return map;
	}
	
	
	
	//ɾ��֪ʶ��
	@RequestMapping(value = "/deleteKnowledgePointByKp_id.action",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,String> deleteKnowledgePointByKp_id(String kp_id){
		
		Map<String, String> map=new HashMap<String, String>();
		int status_code = knowledgePointService.deleteKnowledgePointByKp_id(Integer.valueOf(kp_id));
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
	@RequestMapping(value = "/deleteChapterByCtid.action",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,String> deleteChapterByCid(String ct_id){
		
		Map<String, String> map=new HashMap<String, String>();
		System.out.println(ct_id);
		int status_code = chapterService.deleteChapterByCid(Integer.valueOf(ct_id));
		System.out.println(status_code);
		map.put("status_code",String.valueOf(status_code));
		return map;
		
	}
	
	//��ȡ���еĿγ��б�
	@RequestMapping(value = "/getAllCourses.action",method = RequestMethod.GET)
	public String getCourses(HttpServletRequest request,Model model){
		
	//	System.out.println(courseService==null);
		List<Course> courses=courseService.getAllCourses();
		
		//��ѯ��subject�б����session
		List<Subject> subjectList=subjectService.getAllSubjects();
		//����Ŀ���д��session	
		request.getSession().setAttribute("SUBJECTS_SESSION", subjectList);
		
		model.addAttribute("Courses", courses);
		return "KnowledgePointManage";
		
	}
	
	
	/*���ݿγ̵�id���е��½�*/
	@RequestMapping(value = "/getChapterByCid.action",method = RequestMethod.GET)
	public String getChapters(HttpServletRequest request,String c_id,Model model){
		//String c_id=request.getParameter("c_id");
		//System.out.println(c_id);
		
		//System.out.println("getChapter:"+c_id);
		
		List<ChapterTitle> list=chapterService.getChapterByCid(String.valueOf(c_id));
		model.addAttribute("Chapter",list);
		model.addAttribute("c_id",c_id);
		
		//System.out.println("CourseList:"+list.toString());
		return "ChapterManage";
		
	}
	
	//�½��½ڣ�������
	@RequestMapping(value = "/addChapter.action")
	@ResponseBody
	public Map<String,String> addChapters( @RequestBody ChapterData chapter){
		//String c_id=request.getParameter("c_id");
		String c_id=chapter.getC_id();//��ȡ�½�id
		String ct_name=chapter.getCt_name();
		 Map<String, String> map=new HashMap<String, String>();
	//	System.out.println("111:"+c_id);
		//System.out.println("addChapters222:"+ct_name);
		
		boolean result=chapterService.addChapter(Integer.valueOf(c_id),ct_name);
		if(result){
			map.put("result", "yes");
		}else{
			map.put("result", "no");
		}	
		return map;
		
	}

	//���ݿγ�idɾ���γ�
	@RequestMapping(value = "/deleteCourse.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String,String> deleteCourse(String c_id){
		Map<String, String> map=new HashMap<String, String>();
		//System.out.println(c_id); 
		int status_code=courseService.deleteCourse(Integer.valueOf(c_id));
		//System.out.println(status_code);
		map.put("status_code",String.valueOf(status_code));
		return map;
	}
	//�����½�id��ȡ�½�
	@RequestMapping(value = "/getChapterById.action", method = RequestMethod.GET)
	@ResponseBody
	public ChapterTitle getChapterById(HttpServletRequest request){
		String ct_id=(String) request.getParameter("ct_id");
		//System.out.println("ct_id:"+ct_id);
		ChapterTitle chapter=chapterService.getChapterById(Integer.valueOf(ct_id));
		return chapter;
		
	}
	
	
	//�޸�֪ʶ��
		@RequestMapping(value = "/updateKnowledgePoint.action",method = RequestMethod.POST)
		@ResponseBody
		public Map<String,String> updateChapter(@RequestBody KnowledgePoint knowledgePoint){
			
			Map<String, String> map=new HashMap<String, String>();
			int status_code = knowledgePointService.updateKnowledgePoint(knowledgePoint);
			map.put("status_code",String.valueOf(status_code));
			
			return map;
			
		}
		
		
		////��ȡ֪ʶ��
		@RequestMapping(value = "/getKnowledgePointByKpId.action", method = RequestMethod.GET)
		@ResponseBody
		public KnowledgePoint getKnowledgePointById(HttpServletRequest request){
			String kp_id=(String) request.getParameter("kp_id");
			//System.out.println("ct_id:"+ct_id);
			KnowledgePoint knowledgePoint=knowledgePointService.getKnowledgePointById(Integer.valueOf(kp_id));
			System.out.println(knowledgePoint.toString());
			return knowledgePoint;
			
		}
		
	
	
}
