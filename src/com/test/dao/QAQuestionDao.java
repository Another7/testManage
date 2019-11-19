package com.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.test.po.QAQuestion;
import com.test.po.SCQuestion;
import com.test.pojo.QuestionLevelNumber;

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
	
	//DONE BY RIERBO 问答题mybatis已实现
	/**
	 * 	根据章节id和问答题的难易程度随机生成问答题题目列表
	 * @param chapterIdList 章节id列表
	 * @param levelNumber 问答题难易程度及不同等级需要的题目数量
	 * @return 符合要求的问答题列表
	 */
	public List<QAQuestion> getQAQuestionByChapterIdAndLevelRandom(@	Param("chapterIdList") List<Integer> chapterIdList,
			@	Param("levelNumber") QuestionLevelNumber levelNumber);
}
