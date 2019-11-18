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
	
	// 插入试卷
	public int insertTestPaper(TestPaper testPaper);
}
