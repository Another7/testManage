package com.test.dao;

import com.test.po.Teacher;


public interface TeacherDao {

	//ע��
	public int addTeacher(Teacher teacher);
	//ȡ����(��¼У��)
	public Teacher getTeacherByNameOrEmail(Teacher teacher);
	//�޸��û���Ϣ
	public int updatePwd(Teacher teacher);
	//ɾ���û�
//	public int deleteTeacher(int t_id,String t_name);
	//����û����������Ƿ��Ѿ�����
	public Integer checkUNameOrEmail(Teacher teacher);
}
