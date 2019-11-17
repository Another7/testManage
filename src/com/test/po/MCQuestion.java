package com.test.po;

/**
 * @description ��ѡ��
 * @author zhangyifang
 * @date 2019-10-11
 */
public class MCQuestion {

	private Integer mc_id;//����id
	private Integer mc_subject;//������Ŀid;
	private String mc_point;//�漰����֪ʶ��
	
	
	public MCQuestion(Integer mc_subject, String mc_point, String mc_stem,
			String mc_option, String mc_answer, String mc_analysis,
			String mc_c_id, String mc_ct_id,Integer mc_level) {
		super();
		this.mc_subject = mc_subject;
		this.mc_point = mc_point;
		this.mc_stem = mc_stem;
		this.mc_option = mc_option;
		this.mc_answer = mc_answer;
		this.mc_analysis = mc_analysis;
		this.mc_c_id = mc_c_id;
		this.mc_ct_id = mc_ct_id;
		this.mc_level=mc_level;
	}
	private String mc_stem;//���
	private String mc_option;//ѡ��
	private String mc_answer;//��
	
	private String mc_analysis;//����
	private String mc_t_name;//������
	private String mc_c_id;//�γ̱��
	private String mc_ct_id;//�½ڱ��
	private Integer mc_level;//�����Ѷ�
	
	public Integer getMc_level() {
		return mc_level;
	}

	public void setMc_level(Integer mc_level) {
		this.mc_level = mc_level;
	}

	public MCQuestion(Integer mc_id, Integer mc_subject, String mc_point,
			String mc_stem, String mc_option, String mc_answer,
			String mc_analysis, String mc_t_name, String mc_c_id,
			String mc_ct_id,Integer mc_level) {
		super();
		this.mc_id = mc_id;
		this.mc_subject = mc_subject;
		this.mc_point = mc_point;
		this.mc_stem = mc_stem;
		this.mc_option = mc_option;
		this.mc_answer = mc_answer;
		this.mc_analysis = mc_analysis;
		this.mc_t_name = mc_t_name;
		this.mc_c_id = mc_c_id;
		this.mc_ct_id = mc_ct_id;
		this.mc_level=mc_level;
	}


	@Override
	public String toString() {
		return "MCQuestion [mc_id=" + mc_id + ", mc_subject=" + mc_subject + ", mc_point=" + mc_point + ", mc_stem="
				+ mc_stem + ", mc_option=" + mc_option + ", mc_answer=" + mc_answer + ", mc_analysis=" + mc_analysis
				+ ", mc_t_name=" + mc_t_name + ", mc_c_id=" + mc_c_id + ", mc_ct_id=" + mc_ct_id + ", mc_level="
				+ mc_level + "]";
	}

	public Integer getMc_id() {
		return mc_id;
	}

	public void setMc_id(Integer mc_id) {
		this.mc_id = mc_id;
	}

	public Integer getMc_subject() {
		return mc_subject;
	}

	public void setMc_subject(Integer mc_subject) {
		this.mc_subject = mc_subject;
	}

	public String getMc_point() {
		return mc_point;
	}

	public void setMc_point(String mc_point) {
		this.mc_point = mc_point;
	}

	public String getMc_stem() {
		return mc_stem;
	}

	public void setMc_stem(String mc_stem) {
		this.mc_stem = mc_stem;
	}

	public String getMc_option() {
		return mc_option;
	}

	public void setMc_option(String mc_option) {
		this.mc_option = mc_option;
	}

	public String getMc_answer() {
		return mc_answer;
	}

	public void setMc_answer(String mc_answer) {
		this.mc_answer = mc_answer;
	}

	public String getMc_analysis() {
		return mc_analysis;
	}

	public void setMc_analysis(String mc_analysis) {
		this.mc_analysis = mc_analysis;
	}

	public String getMc_t_name() {
		return mc_t_name;
	}

	public void setMc_t_name(String mc_t_name) {
		this.mc_t_name = mc_t_name;
	}

	public String getMc_c_id() {
		return mc_c_id;
	}

	public void setMc_c_id(String mc_c_id) {
		this.mc_c_id = mc_c_id;
	}

	public String getMc_ct_id() {
		return mc_ct_id;
	}

	public void setMc_ct_id(String mc_ct_id) {
		this.mc_ct_id = mc_ct_id;
	}

	public MCQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}
}
