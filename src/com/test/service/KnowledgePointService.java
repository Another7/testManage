package com.test.service;

import java.util.List;

import com.test.po.KnowledgePoint;

public interface KnowledgePointService {

	//�����½�id��ѯ����֪ʶ��
	public List<KnowledgePoint> getKnowledgePointByCt_id(int ct_id);
	//���֪ʶ��
	public int addKnowledgePoint(KnowledgePoint knowledgePoint);
	//ɾ��֪ʶ��
	public int deleteKnowledgePointByKp_id(int kp_id);
	
}
