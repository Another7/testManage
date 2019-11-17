package com.test.pojo;

import java.util.List;

import com.test.po.MCQuestion;

public class MCQuestionView {
	private String mc_stem;//题干
	private List<String>  mc_option;//选项
	
	public MCQuestionView(MCQuestion mc) {
		
		this.mc_stem = mc.getMc_stem();
		String options[]=mc.getMc_option().split("@@");
				
		for(int i=0;i<options.length;i++) {
			this.mc_option.add(options[i]);
		}
	}
	
	public String getMc_stem() {
		return mc_stem;
	}
	public void setMc_stem(String mc_stem) {
		this.mc_stem = mc_stem;
	}
	
	
	public MCQuestionView() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MCQuestionView(String mc_stem, List<String> mc_option) {
		super();
		this.mc_stem = mc_stem;
		this.mc_option = mc_option;
	}

}
