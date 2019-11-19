package com.test.serviceImpl.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.dao.FBQuestionDao;
import com.test.dao.MCQuestionDao;
import com.test.dao.QAQuestionDao;
import com.test.dao.SCQuestionDao;
import com.test.dao.TFQuestionDao;
import com.test.dao.TestPaperDao;
import com.test.po.TestPaper;
import com.test.pojo.QuestionLevelNumber;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/source/applicationContext.xml")
public class TestPaperTest {


	
	@Autowired
	private SCQuestionDao scq;
	@Autowired
	private QAQuestionDao qaq;
	@Autowired
	private MCQuestionDao mcq;
	@Autowired
	private TFQuestionDao tfq;
	@Autowired
	private FBQuestionDao fbq;

	@Autowired
	private TestPaperDao tpd;

	@Test
	public void test2(){
		TestPaper tp =new TestPaper("test","test",1,"test",1,"test",
				"test","test","test","test","test","test","test");
		System.out.println("--"+tpd.insertTestPaper(tp));
		System.out.println("--"+tp.getTp_id());
		
	}
	
	public void test1(){
		QuestionLevelNumber qn = new QuestionLevelNumber();
		qn.setLevel1(1);
		qn.setLevel2(1);
		qn.setLevel3(1);
		qn.setLevel4(1);
		List<Integer> list=new ArrayList<Integer>();
		list.add(70);
		list.add(71);
		list.add(73);
		scq.getSCQuestionByChapterIdAndLevelRandom(list, qn);
		System.out.println("--scq--");
		qaq.getQAQuestionByChapterIdAndLevelRandom(list, qn);
		System.out.println("--qaq--");
		mcq.getMCQuestionByChapterIdAndLevelRandom(list, qn);
		System.out.println("--mcq--");
		tfq.getTFQuestionByChapterIdAndLevelRandom(list, qn);
		System.out.println("--tfq--");
		fbq.getFBQuestionByChapterIdAndLevelRandom(list, qn);
		System.out.println("--fbq--");
	}
}
