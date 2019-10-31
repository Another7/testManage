package com.test.pojo;

public class ChapterData {

	public ChapterData() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String c_id;
	private String ct_name;
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getCt_name() {
		return ct_name;
	}
	public void setCt_name(String ct_name) {
		this.ct_name = ct_name;
	}
	public ChapterData(String c_id, String ct_name) {
		super();
		this.c_id = c_id;
		this.ct_name = ct_name;
	}
}
