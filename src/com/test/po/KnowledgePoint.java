package com.test.po;

public class KnowledgePoint {

	@Override
	public String toString() {
		return "KnowledgePoint [kp_c_id=" + kp_c_id + ", kp_ct_id=" + kp_ct_id + ", kp_name=" + kp_name + "]";
	}
	private Integer kp_id;
	private Integer kp_c_id;
	private Integer kp_ct_id;
	private String kp_name;
	
	
	
	public KnowledgePoint(Integer kp_c_id, Integer kp_ct_id, String kp_name) {
		super();
		this.kp_c_id = kp_c_id;
		this.kp_ct_id = kp_ct_id;
		this.kp_name = kp_name;
	}
	public Integer getKp_id() {
		return kp_id;
	}
	public void setKp_id(Integer kp_id) {
		this.kp_id = kp_id;
	}
	public Integer getKp_c_id() {
		return kp_c_id;
	}
	public void setKp_c_id(Integer kp_c_id) {
		this.kp_c_id = kp_c_id;
	}
	public Integer getKp_ct_id() {
		return kp_ct_id;
	}
	public void setKp_ct_id(Integer kp_ct_id) {
		this.kp_ct_id = kp_ct_id;
	}
	public String getKp_name() {
		return kp_name;
	}
	public void setKp_name(String kp_name) {
		this.kp_name = kp_name;
	}
	
	
	
}
