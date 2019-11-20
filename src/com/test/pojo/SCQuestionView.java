package com.test.pojo;

import java.util.ArrayList;
import java.util.List;

import com.test.po.SCQuestion;

public class SCQuestionView {

	
	private String sc_stem;//题干
	private List<String> sc_option;//选项
	
	public SCQuestionView(String sc_stem, List<String> sc_option) {
		super();
		this.sc_stem = sc_stem;
		this.sc_option = sc_option;
		
	}
	public SCQuestionView(SCQuestion sc) {
		this.sc_option=new ArrayList<String>();
		this.sc_stem=sc.getSc_stem();
		String options[]=sc.getSc_option().split("@@");
		for(int i=0;i<options.length;i++) {
			this.sc_option.add(options[i]);
		}
		
	}
	@Override
	public String toString() {
		return "SCQuestionView [sc_stem=" + sc_stem + ", sc_option=" + sc_option + "]";
	}
	public SCQuestionView() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSc_stem() {
		return sc_stem;
	}
	public void setSc_stem(String sc_stem) {
		this.sc_stem = sc_stem;
	}
	public List<String> getSc_option() {
		return sc_option;
	}
	public void setSc_option(List<String> sc_option) {
		this.sc_option = sc_option;
	}
	
}
