package com.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.test.po.FBQuestion;
import com.test.po.SCQuestion;
import com.test.po.TFQuestion;
import com.test.pojo.QuestionLevelNumber;



public interface FBQuestionDao {

	
	public int saveFBQuestion(FBQuestion fbQuestion);
	
	/**
	 * 	��������id��ѯ�����
	 * @param fbId ����id
	 * @return ��������
	 */
	public FBQuestion selectFBQuestionById(Integer fbId);
	
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
	
	//DONE BY RIERBO  �����mybatis��ʵ��
	/**
	 * 	�����½�id�����������׳̶�������ɵ�ѡ����Ŀ�б�
	 * @param chapterIdList �½�id�б�
	 * @param levelNumber ��������׳̶ȼ���ͬ�ȼ���Ҫ����Ŀ����
	 * @return ����Ҫ���������б�
	 */
	public List<FBQuestion> getFBQuestionByChapterIdAndLevelRandom(@Param("chapterIdList") List<Integer> chapterIdList,
			@	Param("levelNumber") QuestionLevelNumber levelNumber);

	public int getFbQuestionsNum();
}
