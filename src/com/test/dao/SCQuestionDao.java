package com.test.dao;

import java.util.List;

import com.test.po.SCQuestion;

public interface SCQuestionDao {

	/**
	 * Description ��ӵ�ѡ��
	 * @param question
	 * @return
	 */
	public int saveSCQuestion(SCQuestion question);

	/**
	 * Description  ͨ����Ŀid��ȡ���е�ѡ��
	 * @param sc_subject
	 * @return
	 */
	public List<SCQuestion> getSCQuestionsBySub(Integer sc_subject);

	public int deleteById(Integer sc_id);

	public int updateById(Integer sc_id);
	
	public SCQuestion selectById(Integer sc_id);

	public int updateSCQuestion(SCQuestion scQuestion);
	
	
}
