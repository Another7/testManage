package com.test.po;

public class Teacher {
private Integer t_id;//��ʦid
private String t_name;//��ʦ�û���
private String t_pass;//��ʦ����
private String t_email;//��ʦ�ʼ�



public Teacher(Integer t_id, String t_name, String t_pass, String t_email) {
	super();
	this.t_id = t_id;
	this.t_name = t_name;
	this.t_pass = t_pass;
	this.t_email = t_email;
}
public Teacher(String t_name, String t_pass, String t_email) {
	super();
	this.t_name = t_name;
	this.t_pass = t_pass;
	this.t_email = t_email;
}
public Teacher(String t_name, String t_email) {
	super();
	this.t_name = t_name;
	this.t_email = t_email;
}

public Integer getT_id() {
	return t_id;
}
public void setT_id(Integer t_id) {
	this.t_id = t_id;
}
public String getT_name() {
	return t_name;
}
public void setT_name(String t_name) {
	this.t_name = t_name;
}
public String getT_pass() {
	return t_pass;
}
public void setT_pass(String t_pass) {
	this.t_pass = t_pass;
}
public String getT_email() {
	return t_email;
}
public void setT_email(String t_email) {
	this.t_email = t_email;
}


}
