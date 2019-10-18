package com.test.dao;

import java.util.List;

import com.test.po.FBQuestion;



public interface FBQuestionDao {

	
	public int saveFBQuestion(FBQuestion fbQuestion);
	
	/**
	 * Description  ͨ����Ŀid��ȡ���е�ѡ��
	 * @param fb_subject
	 * @return
	 */
	public List<FBQuestion> getFBQuestionsBySub(Integer fb_subject);

	public int deleteById(Integer fb_id);

	public int updateById(Integer fb_id);
}
