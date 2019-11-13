package com.test.dao;

import java.util.List;

import com.test.po.QAQuestion;

public interface QAQuestionDao {

	public int saveQAQuestion(QAQuestion qaQuestion);

	public List<QAQuestion> getQAQuestionsBySub(Integer qa_subject);

	public int deleteById(Integer qa_id);

	public int updateById(Integer qa_id);
	
	/**
	 * 根据章节id查询问答题
	 * @param chapterIdList 章节id列表
	 * @return 问答题列表
	 */
	public List<QAQuestion> getQAQuestionByChapterId(List<Integer> chapterIdList);
}
