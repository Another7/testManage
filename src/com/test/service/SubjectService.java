package com.test.service;

import java.util.List;

import com.test.po.SCQuestion;
import com.test.po.Subject;




public interface SubjectService {

	/**
	 * Description �õ����еĿ�Ŀ
	 * @return
	 */
	public List<Subject> getAllSubjects();

	/**
	 * Description ͨ��ѡ���Ŀ��id��ȡ��ѡ��
	 * @param sid
	 * @return
	 */
	public List<SCQuestion> getSCQuestionsBySub(String sid);
	
}
