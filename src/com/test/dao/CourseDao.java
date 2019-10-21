package com.test.dao;

import java.util.List;

import com.test.po.Course;


/**
 * @description �γ�dao
 * @author zhangyifang
 * @date 2019-10-21
 */
public interface CourseDao {

	List<Course> getCoursesBySid(Integer s_id);

	boolean addCourse(Course Course);
	
	Course getCourseByName(String c_name);
}
