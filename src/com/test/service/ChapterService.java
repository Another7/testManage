package com.test.service;

import java.util.List;

import com.test.po.ChapterTitle;



public interface ChapterService {


	/**
	 * ���ݿ�Ŀ��id��ȡ�ÿ�Ŀ�µ����пγ��б�
	 */
	public List<ChapterTitle> getChapterByCid(String c_id);
	
	
	//ɾ���½�
	public int deleteChapterByCid(Integer ct_id);
	//�޸��½�
	public int updateChapter(ChapterTitle chapterTitle);

	
	
}
