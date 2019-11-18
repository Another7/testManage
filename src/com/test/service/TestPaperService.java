package com.test.service;

import com.test.po.TestPaper;
import com.test.po.TestPaperView;
import com.test.pojo.TestPaperData;

/**
 * @author Another 
 *
 */
public interface TestPaperService {
	// 随机生成符合要求的试卷
	// 根据章节和题目的难易程度和数量进行随机生成
	public TestPaperView randomCreateTestPaper(TestPaperData testPaperData);
	
	/**
	 * 	插入试卷
	 * @param testPaper 试卷对象
	 * @return 影响行数
	 */
	public int insertTestPaper(TestPaper testPaper);
	
	/**
	 * 	根据试卷id查询试卷
	 * @param testPaperId 试卷id
	 * @return 试卷对象
	 */
	public TestPaper selectTestPaperById(Integer testPaperId);
}
