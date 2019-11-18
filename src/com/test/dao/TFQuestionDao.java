package com.test.dao;


import java.util.List;

import com.test.po.SCQuestion;
import com.test.po.TFQuestion;
import com.test.pojo.QuestionLevelNumber;

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
	
	/**
	 * �����½�id��ѯ�ж���
	 * @param chapterIdList �½�id�б�
	 * @return �ж����б�
	 */
	public List<TFQuestion> getTFQuestionByChapterId(List<Integer> chapterIdList);
	
	//TODO �ж���mybatis��ʵ��
	/**
	 * 	�����½�id���ж�������׳̶���������ж�����Ŀ�б�
	 * @param chapterIdList �½�id�б�
	 * @param levelNumber �ж������׳̶ȼ���ͬ�ȼ���Ҫ����Ŀ����
	 * @return ����Ҫ����ж����б�
	 */
	public List<TFQuestion> getTFQuestionByChapterIdAndLevelRandom(List<Integer> chapterIdList,
			QuestionLevelNumber levelNumber);
}
