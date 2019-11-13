package com.test.dao;

import java.util.List;

import com.test.po.MCQuestion;
import com.test.po.SCQuestion;

public interface MCQuestionDao {

	public int saveMCQuestion(MCQuestion mcQuestion);
	
	/**
	 * Description  通过科目id获取所有多选题
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
	 * 根据章节id查询多选题列表
	 * @param chapterIdList 章节id列表
	 * @return 多选题列表
	 */
	public List<MCQuestion> getMCQuestionByChapterId(List<Integer> chapterIdList);
}
