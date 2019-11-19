package com.test.po;

import java.sql.Timestamp;

public class TestPaper {
	private Integer tp_id;
	private String tp_name;
	private String tp_t_name;
	private Timestamp tp_update_time;
	private Integer tp_status;
	private String tp_illustrate;
	private Integer tp_score;
	private String tp_sc_id;
	private String tp_mc_id;
	private String tp_fb_id;
	private String tp_tf_id;
	private String tp_qa_id;
	private String tp_term;
	private String tp_major;
	private String tp_class;

	
	
	public TestPaper() {
		super();
	}

	public TestPaper(String tp_name, String tp_t_name, Integer tp_status, String tp_illustrate, Integer tp_score,
			String tp_sc_id, String tp_mc_id, String tp_fb_id, String tp_tf_id, String tp_qa_id, String tp_term,
			String tp_major, String tp_class) {
		super();
		this.tp_name = tp_name;
		this.tp_t_name = tp_t_name;
		this.tp_status = tp_status;
		this.tp_illustrate = tp_illustrate;
		this.tp_score = tp_score;
		this.tp_sc_id = tp_sc_id;
		this.tp_mc_id = tp_mc_id;
		this.tp_fb_id = tp_fb_id;
		this.tp_tf_id = tp_tf_id;
		this.tp_qa_id = tp_qa_id;
		this.tp_term = tp_term;
		this.tp_major = tp_major;
		this.tp_class = tp_class;
	}

	public Integer getTp_id() {
		return tp_id;
	}

	public void setTp_id(Integer tp_id) {
		this.tp_id = tp_id;
	}

	public String getTp_name() {
		return tp_name;
	}

	public void setTp_name(String tp_name) {
		this.tp_name = tp_name;
	}

	public String getTp_t_name() {
		return tp_t_name;
	}

	public void setTp_t_name(String tp_t_name) {
		this.tp_t_name = tp_t_name;
	}

	public Timestamp getTp_update_time() {
		return tp_update_time;
	}

	public void setTp_update_time(Timestamp tp_update_time) {
		this.tp_update_time = tp_update_time;
	}

	public Integer getTp_status() {
		return tp_status;
	}

	public void setTp_status(Integer tp_status) {
		this.tp_status = tp_status;
	}

	public String getTp_illustrate() {
		return tp_illustrate;
	}

	public void setTp_illustrate(String tp_illustrate) {
		this.tp_illustrate = tp_illustrate;
	}

	public Integer getTp_score() {
		return tp_score;
	}

	public void setTp_score(Integer tp_score) {
		this.tp_score = tp_score;
	}

	public String getTp_sc_id() {
		return tp_sc_id;
	}

	public void setTp_sc_id(String tp_sc_id) {
		this.tp_sc_id = tp_sc_id;
	}

	public String getTp_mc_id() {
		return tp_mc_id;
	}

	public void setTp_mc_id(String tp_mc_id) {
		this.tp_mc_id = tp_mc_id;
	}

	public String getTp_fb_id() {
		return tp_fb_id;
	}

	public void setTp_fb_id(String tp_fb_id) {
		this.tp_fb_id = tp_fb_id;
	}

	public String getTp_tf_id() {
		return tp_tf_id;
	}

	public void setTp_tf_id(String tp_tf_id) {
		this.tp_tf_id = tp_tf_id;
	}

	public String getTp_qa_id() {
		return tp_qa_id;
	}

	public void setTp_qa_id(String tp_qa_id) {
		this.tp_qa_id = tp_qa_id;
	}

	public String getTp_term() {
		return tp_term;
	}

	public void setTp_term(String tp_term) {
		this.tp_term = tp_term;
	}

	public String getTp_major() {
		return tp_major;
	}

	public void setTp_major(String tp_major) {
		this.tp_major = tp_major;
	}

	public String getTp_class() {
		return tp_class;
	}

	public void setTp_class(String tp_class) {
		this.tp_class = tp_class;
	}
}
