package com.test.dao;

import com.test.po.TestPaper;

/**
 * @author Another
 *
 */
public interface TestPaperDao {
	//TODO testPaper.xml 未创建，待实现
	/**
	 * 	插入试卷
	 * @param testPaper 试卷对象
	 * @return 是否插入成功
	 */
	public int insertTestPaper(TestPaper testPaper);
	
	/**
	 * 	根据单个试卷id查询试卷
	 * @param testPaperId 试卷id
	 * @return 试卷对象
	 */
	public TestPaper selectTestPaperById(Integer testPaperId);
}
