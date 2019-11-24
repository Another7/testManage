package com.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.test.po.MCQuestion;
import com.test.po.SCQuestion;
import com.test.pojo.QuestionLevelNumber;

public interface MCQuestionDao {

	public int saveMCQuestion(MCQuestion mcQuestion);
	
	/**
	 * Description  ͨ����Ŀid��ȡ���ж�ѡ��
	 * @param mc_subject
	 * @return
	 */
	public List<MCQuestion> getMCQuestionsBySub(Integer mc_subject);

	/**
	 * Description TODO
	 * @param mc_id
	 * @return
	 */
	public int deleteById(Integer mc_id);

	public int updateById(Integer mc_id);

	public MCQuestion selectById(Integer mc_id);
	
	/**
	 * �����½�id��ѯ��ѡ���б�
	 * @param chapterIdList �½�id�б�
	 * @return ��ѡ���б�
	 */
	public List<MCQuestion> getMCQuestionByChapterId(List<Integer> chapterIdList);
	
	//DONE BY RIERBO ��ѡ��mybatis��ʵ��
	/**
	 * 	�����½�id�͵�ѡ������׳̶�������ɶ�ѡ����Ŀ�б�
	 * @param chapterIdList �½�id�б�
	 * @param levelNumber ��ѡ�����׳̶ȼ���ͬ�ȼ���Ҫ����Ŀ����
	 * @return ����Ҫ��Ķ�ѡ���б�
	 */
	public List<MCQuestion> getMCQuestionByChapterIdAndLevelRandom(@Param("chapterIdList") List<Integer> chapterIdList,
			@	Param("levelNumber") QuestionLevelNumber levelNumber);

	public int getMcQuestionsNum();
}
