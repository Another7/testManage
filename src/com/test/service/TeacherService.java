package com.test.service;

import com.test.po.Teacher;

public interface TeacherService {
	//ע��
	public int addTeacher(String t_name,String t_pass,String t_email);
	//��¼У��
	public int loginExamine(String t_name,String t_pass,String t_email);
	//�޸�����
	public int updatePwd(String t_name,String t_pass,String t_email);
	//ע��У���û���������
	public int checkUNameOrEmail(Teacher teacher);
	public int getUserNum();
}
