package com.test.dao;

import java.util.List;

import com.test.po.KnowledgePoint;

public interface KnowledgePointDao {

	//根据章节id查询所有知识点
	public List<KnowledgePoint> getKnowledgePointByCt_id(int ct_id);
	//添加知识点
	public int addKnowledgePoint(KnowledgePoint knowledgePoint);
	//删除知识点
	public int deleteKnowledgePointByKp_id(int kp_id);
	public int  updateKnowledgePoint(KnowledgePoint knowledgePoint);
	public KnowledgePoint getKnowledgePointByKp_id(int kp_id);
}
