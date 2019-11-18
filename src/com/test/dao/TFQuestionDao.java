package com.test.dao;


import java.util.List;

import com.test.po.SCQuestion;
import com.test.po.TFQuestion;
import com.test.pojo.QuestionLevelNumber;

public interface TFQuestionDao {

	public int saveTFQuestion(TFQuestion tfQuestion);
	
	
	/**
	 * Description  通过科目id获取所有单选题
	 * @param tf_subject
	 * @return
	 */
	public List<TFQuestion> getTFQuestionsBySub(Integer tf_subject);


	public int deleteById(Integer tf_id);


	public int updateById(Integer tf_id);
	
	/**
	 * 根据章节id查询判断题
	 * @param chapterIdList 章节id列表
	 * @return 判断题列表
	 */
	public List<TFQuestion> getTFQuestionByChapterId(List<Integer> chapterIdList);
	
	//TODO 判断题mybatis待实现
	/**
	 * 	根据章节id和判断题的难易程度随机生成判断题题目列表
	 * @param chapterIdList 章节id列表
	 * @param levelNumber 判断题难易程度及不同等级需要的题目数量
	 * @return 符合要求的判断题列表
	 */
	public List<TFQuestion> getTFQuestionByChapterIdAndLevelRandom(List<Integer> chapterIdList,
			QuestionLevelNumber levelNumber);
}
