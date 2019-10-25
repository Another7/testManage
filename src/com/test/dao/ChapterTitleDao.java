package com.test.dao;

import java.util.List;

import com.test.po.ChapterTitle;

public interface ChapterTitleDao {

	//添加章节
	boolean addChapterTitle(ChapterTitle chapterTitle);
	//获取章节
	List<ChapterTitle> getChaptersByCid(Integer c_id);
	//删除章节
	public int deleteChapterByCid(Integer ct_id);
	//修改章节
	public int updateChapter(ChapterTitle chapterTitle);
}
