package com.test.serviceImpl.test;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.dao.ChapterTitleDao;
import com.test.dao.CourseDao;
import com.test.po.ChapterTitle;
import com.test.po.Course;
import com.test.service.ChapterService;
import com.test.service.CourseService;
@RunWith(SpringJUnit4ClassRunner.class)	// 涓嶈兘鏄疨owerMock绛夊埆鐨刢lass锛屽惁鍒欐棤娉曡瘑鍒玸pring鐨勯厤缃枃浠�
@ContextConfiguration("/source/applicationContext.xml")	// 璇诲彇spring閰嶇疆鏂囦欢
public class ManageTest {

	
	private ChapterService chapterService;
	
	@Autowired
	private CourseService courseService;
	
	
	@Autowired
	ChapterTitleDao chapterTitleDao;
	
	@Autowired
	CourseDao CourseDao;
	
	@Test
	public void delete(){
		ChapterTitle chapterTitle = new ChapterTitle(84,"update_test",25,15);
		chapterService.updateChapter(chapterTitle);
	}
	@Test
	public void getCourses() {
		
		List<Course> courses=courseService.getAllCourses();
		System.out.println(courses);
	}
	
	@Test
	public void testAddChapter() {
		
		/*int chapterNum=chapterTitleDao.getChapterMaxNumByCid(25);*/
		
		Course teBook0=CourseDao.getCourseByName("����");
		System.out.println(teBook0.toString());
	}
}
