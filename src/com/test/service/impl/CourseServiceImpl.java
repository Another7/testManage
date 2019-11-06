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
	 * 把CourseData数据转化到Course表和Chapter_title表中
	 */
	@Override
	public boolean addCourseByBookData(CourseData CourseData) {
		
		//获取CourseData课程名称
		String c_name=CourseData.getc_name();
		//获取CourseData章节编号
		Integer c_chapter_num=CourseData.getc_chapter_num();
		//获取CourseData课程id
		Integer c_s_id=CourseData.getc_s_id();
		//拆分章节
		String chapter[]=CourseData.getc_chapter_headers().split("@@");
		
		
		Course Course=new Course(c_name,c_chapter_num,c_s_id);
		//添加Course
		System.out.println(Course.toString());
		boolean result=CourseDao.addCourse(Course);
		if(result==true){//如果课程添加成功
			System.out.println(c_name);
			Course teBook0=CourseDao.getCourseByName(c_name);
			Integer ct_c_id=Integer.valueOf(teBook0.getc_id());//获得添加成功的课程编号
			//System.out.println("c_chapter_num:"+c_chapter_num);
			//System.out.println("chapter.length:"+chapter.length);
			if(c_chapter_num==chapter.length){//如果分割的章节标题与章节数目对应，添加章节到数据库
				for(int i=0;i<c_chapter_num;i++){
					/*c_ct_id+=i+"@@";*/
					 ChapterTitle chapterTitle=new ChapterTitle(chapter[i], ct_c_id,Integer.valueOf(i+1));//设置chapter章节表中的ct_num自增
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

	@Override
	public Course getCoursesByCid(Integer c_id) {
		
		Course course=CourseDao.getCoursesByCid(c_id);
		return course;
	}

	@Override
	public int updateCourse(Course course) {
		
		int result=CourseDao.updateCourse(course);
		return result;
	}

	@Override
	public int deleteCourse(Integer c_id) {
		// TODO Auto-generated method stub
		Course course = getCoursesByCid(c_id);
		if(course.getc_chapter_num()==0){
			try{
				CourseDao.deleteCourse(c_id);
				return 1;//删除成功
			}catch(Exception e){
				e.printStackTrace();
				return 0;//删除失败
			}
		}else{
			return -1;//章节数不为0不能删除
		}
	}
}


