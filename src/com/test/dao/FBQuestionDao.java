package com.test.dao;

import java.util.List;

import com.test.po.FBQuestion;
import com.test.po.SCQuestion;
import com.test.pojo.QuestionLevelNumber;



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
	
	/**
	 * �����½�id��ѯ�����
	 * @param chapterIdList �½�id�б�
	 * @return ������б�
	 */
	public List<FBQuestion> getFBQuestionByChapterId(List<Integer> chapterIdList);
	
	//TODO �����mybatis��ʵ��
	/**
	 * 	�����½�id�����������׳̶�������ɵ�ѡ����Ŀ�б�
	 * @param chapterIdList �½�id�б�
	 * @param levelNumber ��������׳̶ȼ���ͬ�ȼ���Ҫ����Ŀ����
	 * @return ����Ҫ���������б�
	 */
	public List<FBQuestion> getFBQuestionByChapterIdAndLevelRandom(List<Integer> chapterIdList,
			QuestionLevelNumber levelNumber);
}
