package com.test.service;

import com.test.po.TestPaper;
import com.test.po.TestPaperView;
import com.test.pojo.TestPaperData;

/**
 * @author Another 
 *
 */
public interface TestPaperService {
	// ������ɷ���Ҫ����Ծ�
	// �����½ں���Ŀ�����׳̶Ⱥ����������������
	public TestPaper randomCreateTestPaper(TestPaperData testPaperData);
	
	/**
	 * 	�����Ծ�
	 * @param testPaper �Ծ����
	 * @return Ӱ������
	 */
	public int insertTestPaper(TestPaper testPaper);
	
	/**
	 * 	�����Ծ�id��ѯ�Ծ�
	 * @param testPaperId �Ծ�id
	 * @return �Ծ����
	 */
	public TestPaper selectTestPaperById(Integer testPaperId);
	
	/**
	 * 	��TestPaperת��ΪTestPaperView
	 * @param testPaper �Ծ�
	 * @return �Ծ���ͼ
	 */
	public TestPaperView convertTestPaper(TestPaper testPaper);
}
