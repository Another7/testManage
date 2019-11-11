package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.ChapterTitleDao;
import com.test.dao.KnowledgePointDao;
import com.test.po.ChapterTitle;
import com.test.po.Course;
import com.test.po.KnowledgePoint;
import com.test.service.ChapterService;

@Service
@Transactional
public class ChapterServiceImpl implements ChapterService {

	
	@Autowired 
	ChapterTitleDao chapterTitleDao;
	
	@Autowired
	KnowledgePointDao knowledgePointDao;
	
	@Override
	public List<ChapterTitle> getChapterByCid(String id) {
		
		Integer c_id=Integer.valueOf(id);
		System.out.println("c_id:"+c_id);
		List<ChapterTitle> list=chapterTitleDao.getChaptersByCid(c_id);
		
		return list;
	}
	@Override
	public int deleteChapterByCid(Integer ct_id) {
		
		
		List<KnowledgePoint> list=knowledgePointDao.getKnowledgePointByCt_id(ct_id);
			if(list.size()>0) {//如果章节下面有知识点则不能删除
				return -1;
			}else {
				try{
					
					chapterTitleDao.deleteChapterByCid(ct_id);
					
				}catch(Exception e){
					e.printStackTrace();
					return 0;//删除失败
				}
				return 1;//删除成功
			}
		
	}

	@Override
	public int updateChapter(ChapterTitle chapterTitle) {
		// TODO Auto-generated method stub
		try{
			chapterTitleDao.updateChapter(chapterTitle);
		}catch(Exception e){
			e.printStackTrace();
			return 0;//更新失败
		}
		return 1;//更新成功
	}

	@Override
	public boolean addChapter(Integer c_id,String ct_name) {
		int chapterNum;
		System.out.println("c_id:"+c_id);
		try {
			chapterNum=chapterTitleDao.getChapterMaxNumByCid(c_id);
		}catch (Exception e) {
			chapterNum=0;
		}
		
		System.out.println("chapterNum:"+chapterNum);
		ChapterTitle chapterTitle=new ChapterTitle(ct_name,c_id,chapterNum+1);
		return chapterTitleDao.addChapterTitle(chapterTitle);
	}
	@Override
	public ChapterTitle getChapterById(Integer ct_id) {
		// TODO Auto-generated method stub
		
		return chapterTitleDao.getChapterById(ct_id);
	}
	
	

}
