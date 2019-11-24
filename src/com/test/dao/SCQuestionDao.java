package com.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.test.po.SCQuestion;
import com.test.pojo.QuestionLevelNumber;

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
	
	/**
	 * 	ͨ���½�id��ѯ����ѡ���б�
	 * @param chapterIdList �½�id�б�
	 * @return ��ѡ���б�
	 */
	public List<SCQuestion> getSCQuestionByChapterId(List<Integer> chapterIdList);
	
	//DONE BY RIERBO ��ѡ��mybatis��ʵ��
	/**
	 * 	�����½�id�͵�ѡ������׳̶�������ɵ�ѡ����Ŀ�б�
	 * @param chapterIdList �½�id�б�
	 * @param levelNumber ��ѡ�����׳̶ȼ���ͬ�ȼ���Ҫ����Ŀ����
	 * @return ����Ҫ��ĵ�ѡ���б�
	 */
	public List<SCQuestion> getSCQuestionByChapterIdAndLevelRandom(@	Param("chapterIdList") List<Integer> chapterIdList,
			
			@	Param("levelNumber") QuestionLevelNumber levelNumber);
	
	
	
	public int getScQuestionsNum();

}
