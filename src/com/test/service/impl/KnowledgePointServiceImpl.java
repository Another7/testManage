package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.KnowledgePointDao;
import com.test.po.KnowledgePoint;
import com.test.service.KnowledgePointService;
@Service
@Transactional
public class KnowledgePointServiceImpl implements KnowledgePointService {
	@Autowired
	KnowledgePointDao knowledgePointDao;
	
	@Override
	public List<KnowledgePoint> getKnowledgePointByCt_id(int ct_id) {
		// TODO Auto-generated method stub
		return knowledgePointDao.getKnowledgePointByCt_id(ct_id);
	}

	@Override
	public int addKnowledgePoint(KnowledgePoint knowledgePoint) {
		// TODO Auto-generated method stub
		System.out.println("----service1----");
		knowledgePointDao.addKnowledgePoint(knowledgePoint);
		System.out.println("----service2----");
		return 1;//Ìí¼Ó³É¹¦
	}

	@Override
	public int deleteKnowledgePointByKp_id(int kp_id) {
		// TODO Auto-generated method stub
		knowledgePointDao.deleteKnowledgePointByKp_id(kp_id);
		return 1;
	}

}
