package com.test.dao;

import com.test.po.TestPaper;

/**
 * @author Another
 *
 */
public interface TestPaperDao {
	/**DONE BY RIERBO �����Ծ�
	 * @param testPaper �Ծ����
	 * @return �Ƿ����ɹ�
	 */
	public int insertTestPaper(TestPaper testPaper);
	
	/**DONE BY RIERBO ���ݵ����Ծ�id��ѯ�Ծ�
	 * @param testPaperId �Ծ�id
	 * @return �Ծ����
	 */
	public TestPaper selectTestPaperById(Integer testPaperId);

	public int getTestPaperNum();
}
