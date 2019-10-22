package com.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
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
	@RequestMapping(value = "/getKnowledgePointByCt_id",method = RequestMethod.POST)
	@ResponseBody
	public List<KnowledgePoint> getKnowledgePointByCt_id(@RequestBody int ct_id){
		return knowledgePointService.getKnowledgePointByCt_id(ct_id);
	}
	
	
	
	//添加知识点
	@RequestMapping(value = "/addKnowledgePoint",method = RequestMethod.POST)
	@ResponseBody
	@Test
	public void addKnowledgePoint(){
		KnowledgePoint knowledgePoint=new KnowledgePoint(4,70,"test_knowledgepoint");
//		Map<String, String> map=new HashMap<String, String>();
		int status_code = knowledgePointService.addKnowledgePoint(knowledgePoint);
//		map.put("status_code",String.valueOf(status_code));
//		return map;
		System.out.println("---status_code:"+status_code);
//		System.out.println("---"+knowledgePoint.getKp_name());
	}
	
	//删除知识点
	@RequestMapping(value = "/deleteKnowledgePointByKp_id",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> deleteKnowledgePointByKp_id(@RequestBody int kp_id){
		
		Map<String, String> map=new HashMap<String, String>();
		int status_code = knowledgePointService.deleteKnowledgePointByKp_id(kp_id);
		map.put("status_code",String.valueOf(status_code));
		return map;
		
	}
	
	
}
