package com.test.dao;


import java.util.List;

import com.test.po.TFQuestion;

public interface TFQuestionDao {

	public int saveTFQuestion(TFQuestion tfQuestion);
	
	
	/**
	 * Description  ͨ����Ŀid��ȡ���е�ѡ��
	 * @param tf_subject
	 * @return
	 */
	public List<TFQuestion> getTFQuestionsBySub(Integer tf_subject);


	public int deleteById(Integer tf_id);


	public int updateById(Integer tf_id);
}
