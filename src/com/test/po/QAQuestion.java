package com.test.po;

/**
 * @description �����
 * @author zhangyifang
 * @date 2019-10-11
 */
public class QAQuestion {

	
	private Integer qa_id;//����id
	private Integer qa_subject;//������Ŀid;
	private String qa_point;//�漰����֪ʶ��
	private String qa_stem;//���
	private String qa_answer;//��
	private String qa_analysis;//����
	private String qa_t_name;//������
	private Integer qa_c_id;//�γ̱��
	private Integer qa_ct_id;//�½ڱ��
	public QAQuestion(Integer qa_subject, String qa_point, String qa_stem,
			String qa_answer, String qa_analysis, Integer qa_c_id,
			Integer qa_ct_id) {
		super();
		this.qa_subject = qa_subject;
		this.qa_point = qa_point;
		this.qa_stem = qa_stem;
		this.qa_answer = qa_answer;
		this.qa_analysis = qa_analysis;
		this.qa_c_id = qa_c_id;
		this.qa_ct_id = qa_ct_id;
	}
	public QAQuestion(Integer qa_id, Integer qa_subject, String qa_point,
			String qa_stem, String qa_answer, String qa_analysis,
			String qa_t_name, Integer qa_c_id, Integer qa_ct_id) {
		super();
		this.qa_id = qa_id;
		this.qa_subject = qa_subject;
		this.qa_point = qa_point;
		this.qa_stem = qa_stem;
		this.qa_answer = qa_answer;
		this.qa_analysis = qa_analysis;
		this.qa_t_name = qa_t_name;
		this.qa_c_id = qa_c_id;
		this.qa_ct_id = qa_ct_id;
	}
	public QAQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getQa_id() {
		return qa_id;
	}
	public void setQa_id(Integer qa_id) {
		this.qa_id = qa_id;
	}
	public Integer getQa_subject() {
		return qa_subject;
	}
	public void setQa_subject(Integer qa_subject) {
		this.qa_subject = qa_subject;
	}
	public String getQa_point() {
		return qa_point;
	}
	public void setQa_point(String qa_point) {
		this.qa_point = qa_point;
	}
	public String getQa_stem() {
		return qa_stem;
	}
	public void setQa_stem(String qa_stem) {
		this.qa_stem = qa_stem;
	}
	public String getQa_answer() {
		return qa_answer;
	}
	public void setQa_answer(String qa_answer) {
		this.qa_answer = qa_answer;
	}
	public String getQa_analysis() {
		return qa_analysis;
	}
	public void setQa_analysis(String qa_analysis) {
		this.qa_analysis = qa_analysis;
	}
	
	public Integer getQa_c_id() {
		return qa_c_id;
	}
	public void setQa_c_id(Integer qa_c_id) {
		this.qa_c_id = qa_c_id;
	}
	public Integer getQa_ct_id() {
		return qa_ct_id;
	}
	public String getQa_t_name() {
		return qa_t_name;
	}
	public void setQa_t_name(String qa_t_name) {
		this.qa_t_name = qa_t_name;
	}
	public void setQa_ct_id(Integer qa_ct_id) {
		this.qa_ct_id = qa_ct_id;
	}
	@Override
	public String toString() {
		return "QAQuestion [qa_id=" + qa_id + ", qa_subject=" + qa_subject
				+ ", qa_point=" + qa_point + ", qa_stem=" + qa_stem
				+ ", qa_answer=" + qa_answer + ", qa_analysis=" + qa_analysis
				+ ", qa_t_name=" + qa_t_name + ", qa_c_id=" + qa_c_id
				+ ", qa_ct_id=" + qa_ct_id + "]";
	}
	
	
	
	
	
	
	
	
	
}
