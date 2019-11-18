package com.test.dao;

import java.util.List;

import com.test.po.QAQuestion;
import com.test.po.SCQuestion;
import com.test.pojo.QuestionLevelNumber;

public interface QAQuestionDao {

	public int saveQAQuestion(QAQuestion qaQuestion);

	public List<QAQuestion> getQAQuestionsBySub(Integer qa_subject);

	public int deleteById(Integer qa_id);

	public int updateById(Integer qa_id);
	
	/**
	 * �����½�id��ѯ�ʴ���
	 * @param chapterIdList �½�id�б�
	 * @return �ʴ����б�
	 */
	public List<QAQuestion> getQAQuestionByChapterId(List<Integer> chapterIdList);
	
	//TODO �ʴ���mybatis��ʵ��
	/**
	 * 	�����½�id���ʴ�������׳̶���������ʴ�����Ŀ�б�
	 * @param chapterIdList �½�id�б�
	 * @param levelNumber �ʴ������׳̶ȼ���ͬ�ȼ���Ҫ����Ŀ����
	 * @return ����Ҫ����ʴ����б�
	 */
	public List<QAQuestion> getQAQuestionByChapterIdAndLevelRandom(List<Integer> chapterIdList,
			QuestionLevelNumber levelNumber);
}
