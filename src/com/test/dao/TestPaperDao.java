package com.test.dao;

import com.test.po.TestPaper;

/**
 * @author Another
 *
 */
public interface TestPaperDao {
	//TODO testPaper.xml δ��������ʵ��
	/**
	 * 	�����Ծ�
	 * @param testPaper �Ծ����
	 * @return �Ƿ����ɹ�
	 */
	public int insertTestPaper(TestPaper testPaper);
	
	/**
	 * 	���ݵ����Ծ�id��ѯ�Ծ�
	 * @param testPaperId �Ծ�id
	 * @return �Ծ����
	 */
	public TestPaper selectTestPaperById(Integer testPaperId);
}
