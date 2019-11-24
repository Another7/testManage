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
	 * 	根据主键id查询填空题
	 * @param fbId 主键id
	 * @return 填空题对象
	 */
	public FBQuestion selectFBQuestionById(Integer fbId);
	
	/**
	 * Description  通过科目id获取所有单选题
	 * @param fb_subject
	 * @return
	 */
	public List<FBQuestion> getFBQuestionsBySub(Integer fb_subject);

	public int deleteById(Integer fb_id);

	public int updateById(Integer fb_id);
	
	/**
	 * 根据章节id查询填空题
	 * @param chapterIdList 章节id列表
	 * @return 填空题列表
	 */
	public List<FBQuestion> getFBQuestionByChapterId(List<Integer> chapterIdList);
	
	//DONE BY RIERBO  填空题mybatis已实现
	/**
	 * 	根据章节id和填空题的难易程度随机生成单选题题目列表
	 * @param chapterIdList 章节id列表
	 * @param levelNumber 填空题难易程度及不同等级需要的题目数量
	 * @return 符合要求的填空题列表
	 */
	public List<FBQuestion> getFBQuestionByChapterIdAndLevelRandom(@Param("chapterIdList") List<Integer> chapterIdList,
			@	Param("levelNumber") QuestionLevelNumber levelNumber);

	public int getFbQuestionsNum();
}
