package com.test.serviceImpl.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.dao.ChapterTitleDao;
import com.test.po.ChapterTitle;
import com.test.service.ChapterService;
@RunWith(SpringJUnit4ClassRunner.class)	// 不能是PowerMock等别的class，否则无法识别spring的配置文件
@ContextConfiguration("/source/applicationContext.xml")	// 读取spring配置文件
public class ManageTest {

	@Autowired
	private ChapterService chapterService;
	
	@Autowired
	ChapterTitleDao chapterTitleDao;
	@Test
	public void delete(){
		ChapterTitle chapterTitle = new ChapterTitle(84,"update_test",25,15);
		chapterService.updateChapter(chapterTitle);
	}
}
