package com.test.dao;

import java.util.List;

import com.test.po.ChapterTitle;
import com.test.po.Course;

public interface ChapterTitleDao {

	//添加章节
	boolean addChapterTitle(ChapterTitle chapterTitle);
	//获取章节
	List<ChapterTitle> getChaptersByCid(Integer c_id);
	//删除章节
	public int deleteChapterByCid(Integer ct_id);
	//修改章节
	public int updateChapter(ChapterTitle chapterTitle);
	//获取所有章节列表
	public List<Course> getAllCourses();
	//获取给定的课程id的章节序号最大值
	public  int getChapterMaxNumByCid(int c_id);
	
}
