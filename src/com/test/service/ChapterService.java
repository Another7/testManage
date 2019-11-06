package com.test.service;

import java.util.List;

import com.test.po.ChapterTitle;
import com.test.po.Course;




public interface ChapterService {


	/**
	 * 根据科目的id获取该科目下的所有课程列表
	 */
	public List<ChapterTitle> getChapterByCid(String c_id);
	
	
	//删除章节
	public int deleteChapterByCid(Integer ct_id);
	//修改章节
	public int updateChapter(ChapterTitle chapterTitle);
	
	//添加章节
	public boolean addChapter(Integer c_id,String ct_name);

	//根据章节id查章节信息
	public ChapterTitle getChapterById(Integer ct_id);
	
	
}
