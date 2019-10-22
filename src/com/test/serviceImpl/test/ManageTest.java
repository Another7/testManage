package com.test.serviceImpl.test;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.test.dao.KnowledgePointDao;
import com.test.po.KnowledgePoint;
import com.test.service.KnowledgePointService;

public class ManageTest {

	@Autowired
	private KnowledgePointService knowledgePointService;
	
	@Autowired
	KnowledgePointDao knowledgePointDao;
	@Test
	public void addKnowledgePoint(){
		KnowledgePoint knowledgePoint=new KnowledgePoint(4,70,"test_knowledgepoint");
		//System.out.println(knowledgePoint.toString());
//		Map<String, String> map=new HashMap<String, String>();
	//	knowledgePointService.addKnowledgePoint(knowledgePoint);
//		map.put("status_code",String.valueOf(status_code));
//		return map;
		//System.out.println("---status_code:"+status_code);
//		System.out.println("---"+knowledgePoint.getKp_name());
		knowledgePointDao.addKnowledgePoint(knowledgePoint);
	}
}
