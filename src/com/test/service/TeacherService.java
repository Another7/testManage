package com.test.service;


public interface TeacherService {
	//ע��
	public int addTeacher(String t_name,String t_pass,String t_email);
	//��¼У��
	public int loginExamine(String t_name,String t_pass,String t_email);
	//�޸�����
	public int updatePwd(String t_name,String t_pass,String t_email);
}
