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
	public TestPaperView randomCreateTestPaper(TestPaperData testPaperData);
	
	// �����Ծ�
	public int insertTestPaper(TestPaper testPaper);
}
