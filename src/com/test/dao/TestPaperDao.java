package com.test.dao;

import com.test.po.TestPaper;

/**
 * @author Another
 *
 */
public interface TestPaperDao {
	/**DONE BY RIERBO 插入试卷
	 * @param testPaper 试卷对象
	 * @return 是否插入成功
	 */
	public int insertTestPaper(TestPaper testPaper);
	
	/**DONE BY RIERBO 根据单个试卷id查询试卷
	 * @param testPaperId 试卷id
	 * @return 试卷对象
	 */
	public TestPaper selectTestPaperById(Integer testPaperId);

	public int getTestPaperNum();
}
