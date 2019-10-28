package com.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.po.Course;
import com.test.pojo.CourseData;

@Service
public interface CourseService {
	
	/**
	 * ����Subject��Ŀ��id��ѯ���еĿγ�
	 */
	public List<Course> getCoursesBySid(String s_id);
	
	/**
	 * ����CourseData���Course����
	 */
	public boolean addCourseByBookData(CourseData CourseData);
	
	public List<Course> getAllCourses();
}
