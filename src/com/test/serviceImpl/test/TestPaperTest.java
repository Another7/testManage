package com.test.serviceImpl.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.pojo.QuestionLevelNumber;
import com.test.service.QuestionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/source/applicationContext.xml")
public class TestPaperTest {

	@Autowired
	private QuestionService questionService;
	
	@Test
	public void test() {
		List<Integer> chapterIdList = new ArrayList<Integer>();
		chapterIdList.add(78);
		chapterIdList.add(28);
		chapterIdList.add(39);
		chapterIdList.add(40);
		chapterIdList.add(74);
		chapterIdList.add(75);
		chapterIdList.add(76);
		chapterIdList.add(71);
		Map<String, QuestionLevelNumber> resultMap = questionService.countQuestionLevelNumber(chapterIdList);
		resultMap.forEach((key, questionLevelNumber) -> {
			System.out.print(key);
			System.out.print(questionLevelNumber.getLevel1());
			System.out.print(questionLevelNumber.getLevel2());
			System.out.print(questionLevelNumber.getLevel3());
			System.out.print(questionLevelNumber.getLevel4());
			System.out.println();
		});
	}

}
