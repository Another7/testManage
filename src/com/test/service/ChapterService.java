package com.test.service;

import java.util.List;

import com.test.po.ChapterTitle;



public interface ChapterService {


	/**
	 * ���ݿ�Ŀ��id��ȡ�ÿ�Ŀ�µ����пα��б�
	 */
	public List<ChapterTitle> getChapterByTBid(String tb_id);
}
