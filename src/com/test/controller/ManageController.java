package com.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.po.KnowledgePoint;
import com.test.service.KnowledgePointService;

@Controller
public class ManageController {

	@Autowired
	private KnowledgePointService knowledgePointService;
	
	//根据章节id查询该章节下的所有知识点
	@RequestMapping(value = "/getKnowledgePointByCt_id.action",method = RequestMethod.POST)
	@ResponseBody
	public List<KnowledgePoint> getKnowledgePointByCt_id(int ct_id){
		System.out.println("getKnowledgePointByCt_id:"+ct_id);
		List<KnowledgePoint> list=knowledgePointService.getKnowledgePointByCt_id(ct_id); 
		System.out.println(list.toString());
		return list;
	}
	
	
	
	//添加知识点
	@RequestMapping(value = "/addKnowledgePoint.action",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,String> addKnowledgePoint(@RequestBody KnowledgePoint knowledgePoint){
		Map<String, String> map=new HashMap<String, String>();
		int status_code = knowledgePointService.addKnowledgePoint(knowledgePoint);
		map.put("status_code",String.valueOf(status_code));
		return map;
	}
	
	
	
	//删除知识点
	@RequestMapping(value = "/deleteKnowledgePointByKp_id.action",method = RequestMethod.GET)
	@ResponseBody
	public Map<String,String> deleteKnowledgePointByKp_id(int kp_id){
		
		Map<String, String> map=new HashMap<String, String>();
		int status_code = knowledgePointService.deleteKnowledgePointByKp_id(kp_id);
		map.put("status_code",String.valueOf(status_code));
		return map;
		
	}
	
	
}
