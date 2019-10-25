package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.ChapterTitleDao;
import com.test.po.ChapterTitle;
import com.test.service.ChapterService;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {

	
	
	@Autowired 
	ChapterTitleDao chapterTitleDao;
	
	@Override
	public List<ChapterTitle> getChapterByCid(String id) {
		
		Integer c_id=Integer.valueOf(id);
		System.out.println("c_id:"+c_id);
		List<ChapterTitle> list=chapterTitleDao.getChaptersByCid(c_id);
		
		return list;
	}

	@Override
	public int deleteChapterByCid(Integer ct_id) {
		// TODO Auto-generated method stub
		try{
			chapterTitleDao.deleteChapterByCid(ct_id);
		}catch(Exception e){
			e.printStackTrace();
			return 0;//ɾ��ʧ��
		}
		return 1;//ɾ���ɹ�
	}

	@Override
	public int updateChapter(ChapterTitle chapterTitle) {
		// TODO Auto-generated method stub
		try{
			chapterTitleDao.updateChapter(chapterTitle);
		}catch(Exception e){
			e.printStackTrace();
			return 0;//����ʧ��
		}
		return 1;//���³ɹ�
	}

}
