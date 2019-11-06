package com.test.service;

import java.util.List;

import com.test.po.ChapterTitle;
import com.test.po.Course;




public interface ChapterService {


	/**
	 * ���ݿ�Ŀ��id��ȡ�ÿ�Ŀ�µ����пγ��б�
	 */
	public List<ChapterTitle> getChapterByCid(String c_id);
	
	
	//ɾ���½�
	public int deleteChapterByCid(Integer ct_id);
	//�޸��½�
	public int updateChapter(ChapterTitle chapterTitle);
	
	//����½�
	public boolean addChapter(Integer c_id,String ct_name);

	//�����½�id���½���Ϣ
	public ChapterTitle getChapterById(Integer ct_id);
	
	
}
