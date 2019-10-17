package com.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.TeacherDao;
import com.test.po.Teacher;
import com.test.service.TeacherService;
@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {
	@Autowired
	TeacherDao teacherDao;
	@Override
	public int addTeacher(String t_name, String t_pass, String t_email) {
		// TODO Auto-generated method stub
		try{
			teacherDao.addTeacher(new Teacher(t_name, t_pass, t_email));
		}catch(Exception e){
			e.printStackTrace();
			return 0;//ע��ʧ��(�û���/�����ظ�)
		}
		return 1;//ע��ɹ�
	}

	@Override
	public int loginExamine(String t_name,String t_pass, String t_email) {
		// TODO Auto-generated method stub
		try{
			Teacher teacher=teacherDao.getTeacherByNameOrEmail(new Teacher(t_name, t_email));
			if(teacher.getT_pass().equals(t_pass)){
				return 1;//У��ɹ�
			}
		}catch(Exception e){
			return -1;//�û�������
		}
		return 0;//�������
	}

	@Override
	public int updatePwd(String t_name, String t_pass, String t_email) {
		// TODO Auto-generated method stub
		try{
			teacherDao.updatePwd(new Teacher(t_name, t_pass, t_email));
		}catch(Exception e){
			return 0;
		}
		return 1;//�޸ĳɹ�
	}
	
	public int checkUNameOrEmail(Teacher teacher) {
	
		if(teacherDao.checkUNameOrEmail(teacher)!=null) {
		
			return 1;
		}
		return 0;
			
	}

}
