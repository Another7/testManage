package com.test.pojo;

import java.util.ArrayList;
import java.util.List;

import com.test.po.MCQuestion;

public class MCQuestionView {
	private String mc_stem;//���
	private List<String>  mc_option;//ѡ��
	
	public MCQuestionView(MCQuestion mc) {
		this.mc_option=new ArrayList<String>();
		this.mc_stem = mc.getMc_stem();
		String options[]=mc.getMc_option().split("@@");
				
		for(int i=0;i<options.length;i++) {
			this.mc_option.add(options[i]);
		}
	}
	public MCQuestionView(String mc_stem, List<String> mc_option) {
		super();
		this.mc_stem = mc_stem;
		this.mc_option = mc_option;
	}
	public String getMc_stem() {
		return mc_stem;
	}
	public void setMc_stem(String mc_stem) {
		this.mc_stem = mc_stem;
	}
	public List<String> getMc_option() {
		return mc_option;
	}
	public void setMc_option(List<String> mc_option) {
		this.mc_option = mc_option;
	}
	
	
	
	

}
