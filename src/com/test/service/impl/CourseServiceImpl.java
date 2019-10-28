package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.ChapterTitleDao;
import com.test.dao.CourseDao;
import com.test.po.ChapterTitle;
import com.test.po.Course;
import com.test.pojo.CourseData;
import com.test.service.CourseService;
@Service
@Transactional
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseDao CourseDao;
	
	@Autowired 
	ChapterTitleDao chapterTitleDao;
	@Override
	public List<Course> getCoursesBySid(String sid) {

		Integer s_id=Integer.valueOf(sid);
		System.out.println("s_id:"+s_id);
		List<Course> list=CourseDao.getCoursesBySid(s_id);
		return list;
	}

	/**
	 * ��CourseData����ת����Course���Chapter_title����
	 */
	@Override
	public boolean addCourseByBookData(CourseData CourseData) {
		
		
		String c_name=CourseData.getc_name();
		Integer c_chapter_num=CourseData.getc_chapter_num();
		Integer c_s_id=CourseData.getc_s_id();
		
		String chapter[]=CourseData.getc_chapter_headers().split("@@");
		
		
		Course Course=new Course(c_name,c_chapter_num,c_s_id);
		//���Course
		System.out.println(Course.toString());
		boolean result=CourseDao.addCourse(Course);
		if(result==true){//����γ���ӳɹ�
			
			Course teBook0=CourseDao.getCourseByName(c_name);
			Integer ct_c_id=Integer.valueOf(teBook0.getc_id());//�����ӳɹ��Ŀγ̱��
			System.out.println("c_chapter_num:"+c_chapter_num);
			System.out.println("chapter.length:"+chapter.length);
			if(c_chapter_num==chapter.length){//����ָ���½ڱ������½���Ŀ��Ӧ������½ڵ����ݿ�
				for(int i=0;i<c_chapter_num;i++){
					/*c_ct_id+=i+"@@";*/
					 ChapterTitle chapterTitle=new ChapterTitle(chapter[i], ct_c_id,Integer.valueOf(i+1));
					 chapterTitleDao.addChapterTitle(chapterTitle);
				}
			}
			
			
			
		}
		
		
		return result;
	}
  
	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		List<Course> list=chapterTitleDao.getAllCourses();
		
		return list;
	}
}


