package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.po.FBQuestion;
import com.test.po.MCQuestion;
import com.test.po.QAQuestion;
import com.test.po.SCQuestion;
import com.test.po.TFQuestion;
import com.test.pojo.QuestionLevelNumber;
import com.test.pojo.SCQuestionData;


public interface QuestionService {

	public int saveSCQuestion(SCQuestionData scQuestionData);  //���뵥ѡ���⣬��ʵ����Ϊ����
	
	public int saveMCQuestion(MCQuestion mcQuestion);  //�����ѡ�⣬��ʵ����Ϊ����
	
	public int saveFBQuestion(FBQuestion fbQuestion);  //��������⣬��ʵ����Ϊ����
	
	public int saveTFQuestion(TFQuestion tfQuestion);  //�����ж��⣬��ʵ����Ϊ����
	
	public int saveQAQuestion(QAQuestion qaQuestion);  //�������⣬��ʵ����Ϊ����
	
	public List<SCQuestion> getAllSCQuestions(String subjectId);//��ȡ���еĵ�ѡ��
	
	public List<MCQuestion> getAllMCQuestions(String subjectId);//��ȡ���еĶ�ѡ��
	
	public List<TFQuestion> getAllTFQuestions(String subjectId);//��ȡ���е��ж���
	
	public List<FBQuestion> getAllFBQuestions(String subjectId);//��ȡ���е������
	
	public List<QAQuestion> getAllQAQuestions(String subjectId);//��ȡ���еļ����

	public boolean deleteSCQuestion(String sc_id);//ɾ����ѡ��

	public boolean deleteQAQuestion(String qa_id);//ɾ�������

	public boolean deleteFBQuestion(String fb_id);//ɾ�������

	public boolean deleteTFQuestion(String tf_id);//ɾ���ж���

	public boolean deleteMCQuestion(String mc_id);//ɾ����ѡ��

	public boolean updateQAQuestion(String qa_id);

	public boolean updateFBQuestion(String fb_id);

	public boolean updateTFQuestion(String tf_id);

	public boolean updateMCQuestion(String mc_id);

	public boolean updateSCQuestion(SCQuestionData scquestionData);
	
	public SCQuestion selectSCQuestionById(String sc_id);

	public MCQuestion selectMCQuestionById(String mc_id);

	public TFQuestion selectTFQuestionById(String tf_id);

	public FBQuestion selectFBQuestionById(String fb_id);

	public QAQuestion selectQAQuestionById(String qa_id);
	
	
	public int getQuestionsNum();//ͳ��������Ŀ
	
	public int getTestPaperNum();//ͳ���Ծ���
	
	public int getUserNum();//ͳ���û���
	
	
	
	/**
	 * �����½�id��ѯ��Ӧ������Ĳ�ͬ�ȼ�������
	 * @param chapterIdList �½�id�б�
	 * @return ��ͬ���͵���Ŀ����Ӧ�Ĳ�ͬ�Ѷȵ���Ŀ����
	 */
	public Map<String, QuestionLevelNumber> countQuestionLevelNumber(List<Integer> chapterIdList);
}
