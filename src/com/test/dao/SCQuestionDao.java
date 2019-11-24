package com.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.test.po.SCQuestion;
import com.test.pojo.QuestionLevelNumber;

public interface SCQuestionDao {

	/**
	 * Description 添加单选题
	 * @param question
	 * @return
	 */
	public int saveSCQuestion(SCQuestion question);

	/**
	 * Description  通过科目id获取所有单选题
	 * @param sc_subject
	 * @return
	 */
	public List<SCQuestion> getSCQuestionsBySub(Integer sc_subject);

	public int deleteById(Integer sc_id);

	public int updateById(Integer sc_id);
	
	public SCQuestion selectById(Integer sc_id);

	public int updateSCQuestion(SCQuestion scQuestion);
	
	/**
	 * 	通过章节id查询出单选题列表
	 * @param chapterIdList 章节id列表
	 * @return 单选题列表
	 */
	public List<SCQuestion> getSCQuestionByChapterId(List<Integer> chapterIdList);
	
	//DONE BY RIERBO 单选题mybatis已实现
	/**
	 * 	根据章节id和单选题的难易程度随机生成单选题题目列表
	 * @param chapterIdList 章节id列表
	 * @param levelNumber 单选题难易程度及不同等级需要的题目数量
	 * @return 符合要求的单选题列表
	 */
	public List<SCQuestion> getSCQuestionByChapterIdAndLevelRandom(@	Param("chapterIdList") List<Integer> chapterIdList,
			
			@	Param("levelNumber") QuestionLevelNumber levelNumber);
	
	
	
	public int getScQuestionsNum();

}
