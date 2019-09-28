package com.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.test.po.TextBook;
import com.test.pojo.TextBookData;

@Service
public interface TextBookService {
	
	/**
	 * ����Subject��Ŀ��id��ѯ���еĽ̿���
	 */
	public List<TextBook> getTextBooksBySid(String s_id);
	
	/**
	 * ����TextBookData���TextBook����
	 */
	public boolean addTextBookByBookData(TextBookData textBookData);
}
