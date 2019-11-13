package com.test.dao;

import java.util.List;

import com.test.po.FBQuestion;



public interface FBQuestionDao {

	
	public int saveFBQuestion(FBQuestion fbQuestion);
	
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
}
