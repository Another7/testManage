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
		knowledgePointDao.addKnowledgePoint(knowledgePoint);
		return 1;//添加成功
	}

	@Override
	public int deleteKnowledgePointByKp_id(int kp_id) {
		// TODO Auto-generated method stub
		knowledgePointDao.deleteKnowledgePointByKp_id(kp_id);
		return 1;
	}

	@Override
	public int updateKnowledgePoint(KnowledgePoint knowledgePoint) {
		try{
			knowledgePointDao.updateKnowledgePoint(knowledgePoint);
		}catch(Exception e){
			return 0;//更新失败
		}
		return 1;//更新成功
	}

	@Override
	public KnowledgePoint getKnowledgePointById(int kp_id) {
		
		
		return knowledgePointDao.getKnowledgePointByKp_id(kp_id);
	}

}
