package com.test.serviceImpl.test;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.test.dao.KnowledgePointDao;
import com.test.po.KnowledgePoint;
import com.test.service.KnowledgePointService;

@RunWith(SpringJUnit4ClassRunner.class)	// ������PowerMock�ȱ��class�������޷�ʶ��spring�������ļ�
@ContextConfiguration("/source/applicationContext.xml")	// ��ȡspring�����ļ�
public class ManageTest {

	@Autowired
	private KnowledgePointService knowledgePointService;
	
	@Autowired
	KnowledgePointDao knowledgePointDao;
	
	
	@Test
	public void addKnowledgePoint(){
		KnowledgePoint knowledgePoint=new KnowledgePoint(4,71,"test_knowledgepoint");
		//System.out.println(knowledgePoint.toString());
//		Map<String, String> map=new HashMap<String, String>();
	//	knowledgePointService.addKnowledgePoint(knowledgePoint);
//		map.put("status_code",String.valueOf(status_code));
//		return map;
		//System.out.println("---status_code:"+status_code);
		//System.out.println(knowledgePointDao==null);
		
	//	knowledgePointDao.addKnowledgePoint(knowledgePoint);
		knowledgePointDao.getKnowledgePointByCt_id(70);
		
	}
}
