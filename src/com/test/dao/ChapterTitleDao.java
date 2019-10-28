package com.test.dao;

import java.util.List;

import com.test.po.ChapterTitle;
import com.test.po.Course;

public interface ChapterTitleDao {

	//����½�
	boolean addChapterTitle(ChapterTitle chapterTitle);
	//��ȡ�½�
	List<ChapterTitle> getChaptersByCid(Integer c_id);
	//ɾ���½�
	public int deleteChapterByCid(Integer ct_id);
	//�޸��½�
	public int updateChapter(ChapterTitle chapterTitle);
	public List<Course> getAllCourses();
	
}
