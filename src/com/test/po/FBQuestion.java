package com.test.po;

/**
 * @description �����
 * @author zhangyifang
 * @date 2019-10-11
 */
public class FBQuestion {

	private Integer fb_id;//����id
	private Integer fb_subject;//������Ŀid;
	private String fb_point;//�漰����֪ʶ��
	private String fb_stem;//���
	
	private String fb_answer;//��
	
	private String fb_t_name;//����
	private String fb_analysis;//������
	private Integer fb_c_id;//�γ̱��
	private Integer fb_ct_id;//�½ڱ��
	
	public FBQuestion(Integer fb_subject, String fb_point, String fb_stem,
			String fb_answer, String fb_analysis, Integer fb_c_id,
			Integer fb_ct_id) {
		super();
		this.fb_subject = fb_subject;
		this.fb_point = fb_point;
		this.fb_stem = fb_stem;
		this.fb_answer = fb_answer;
		this.fb_analysis = fb_analysis;
		this.fb_c_id = fb_c_id;
		this.fb_ct_id = fb_ct_id;
	}

	public FBQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getFb_id() {
		return fb_id;
	}

	public void setFb_id(Integer fb_id) {
		this.fb_id = fb_id;
	}

	public Integer getFb_subject() {
		return fb_subject;
	}

	public void setFb_subject(Integer fb_subject) {
		this.fb_subject = fb_subject;
	}

	public String getFb_point() {
		return fb_point;
	}

	public void setFb_point(String fb_point) {
		this.fb_point = fb_point;
	}

	public String getFb_stem() {
		return fb_stem;
	}

	public void setFb_stem(String fb_stem) {
		this.fb_stem = fb_stem;
	}

	public String getFb_answer() {
		return fb_answer;
	}

	public void setFb_answer(String fb_answer) {
		this.fb_answer = fb_answer;
	}

	public String getFb_t_name() {
		return fb_t_name;
	}

	public void setFb_t_name(String fb_t_name) {
		this.fb_t_name = fb_t_name;
	}

	public FBQuestion(Integer fb_id, Integer fb_subject, String fb_point,
			String fb_stem, String fb_answer, String fb_t_name,
			String fb_analysis, Integer fb_c_id, Integer fb_ct_id) {
		super();
		this.fb_id = fb_id;
		this.fb_subject = fb_subject;
		this.fb_point = fb_point;
		this.fb_stem = fb_stem;
		this.fb_answer = fb_answer;
		this.fb_t_name = fb_t_name;
		this.fb_analysis = fb_analysis;
		this.fb_c_id = fb_c_id;
		this.fb_ct_id = fb_ct_id;
	}

	public String getFb_analysis() {
		return fb_analysis;
	}

	public void setFb_analysis(String fb_analysis) {
		this.fb_analysis = fb_analysis;
	}

	public Integer getFb_c_id() {
		return fb_c_id;
	}

	public void setFb_c_id(Integer fb_c_id) {
		this.fb_c_id = fb_c_id;
	}

	public Integer getFb_ct_id() {
		return fb_ct_id;
	}

	public void setFb_ct_id(Integer fb_ct_id) {
		this.fb_ct_id = fb_ct_id;
	}

	@Override
	public String toString() {
		return "FBQuestion [fb_id=" + fb_id + ", fb_subject=" + fb_subject
				+ ", fb_point=" + fb_point + ", fb_stem=" + fb_stem
				+ ", fb_answer=" + fb_answer + ", fb_t_name=" + fb_t_name
				+ ", fb_analysis=" + fb_analysis + ", fb_c_id=" + fb_c_id
				+ ", fb_ct_id=" + fb_ct_id + "]";
	}
	
	

	
}
