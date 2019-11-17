package com.test.po;

import java.util.List;

import com.test.pojo.MCQuestionView;
import com.test.pojo.SCQuestionView;

public class TestPaperView {
	private String tpName;
	private String tpIllustrate;
	private String tpTerm;
	private String tpClass;
	private String tpCreateName;//创建者姓名
	private List<SCQuestionView> scQuestions;
	private List<MCQuestionView> mcQuestions;
	private List<FBQuestion> fbQuestions;
	private List<TFQuestion> tfQuestions;
	private List<QAQuestion> qaQuestion;
	public String getTpName() {
		return tpName;
	}
	public void setTpName(String tpName) {
		this.tpName = tpName;
	}
	public String getTpIllustrate() {
		return tpIllustrate;
	}
	public void setTpIllustrate(String tpIllustrate) {
		this.tpIllustrate = tpIllustrate;
	}
	public String getTpTerm() {
		return tpTerm;
	}
	public void setTpTerm(String tpTerm) {
		this.tpTerm = tpTerm;
	}
	public String getTpClass() {
		return tpClass;
	}
	public void setTpClass(String tpClass) {
		this.tpClass = tpClass;
	}
	public String getTpCreateName() {
		return tpCreateName;
	}
	public void setTpCreateName(String tpCreateName) {
		this.tpCreateName = tpCreateName;
	}
	
	public List<SCQuestionView> getScQuestions() {
		return scQuestions;
	}
	public void setScQuestions(List<SCQuestionView> scQuestions) {
		this.scQuestions = scQuestions;
	}
	public List<MCQuestionView> getMcQuestions() {
		return mcQuestions;
	}
	public void setMcQuestions(List<MCQuestionView> mcQuestions) {
		this.mcQuestions = mcQuestions;
	}
	public List<FBQuestion> getFbQuestions() {
		return fbQuestions;
	}
	public void setFbQuestions(List<FBQuestion> fbQuestions) {
		this.fbQuestions = fbQuestions;
	}
	public List<TFQuestion> getTfQuestions() {
		return tfQuestions;
	}
	public void setTfQuestions(List<TFQuestion> tfQuestions) {
		this.tfQuestions = tfQuestions;
	}
	public List<QAQuestion> getQaQuestion() {
		return qaQuestion;
	}
	public void setQaQuestion(List<QAQuestion> qaQuestion) {
		this.qaQuestion = qaQuestion;
	}
	@Override
	public String toString() {
		return "TestPaperView [tpName=" + tpName + ", tpIllustrate=" + tpIllustrate + ", tpTerm=" + tpTerm
				+ ", tpClass=" + tpClass + ", tpCreateName=" + tpCreateName + ", scQuestions=" + scQuestions
				+ ", mcQuestions=" + mcQuestions + ", fbQuestions=" + fbQuestions + ", tfQuestions=" + tfQuestions
				+ ", qaQuestion=" + qaQuestion + "]";
	}
	public TestPaperView(String tpName, String tpIllustrate, String tpTerm, String tpClass, String tpCreateName,
			List<SCQuestionView> scQuestions, List<MCQuestionView> mcQuestions, List<FBQuestion> fbQuestions,
			List<TFQuestion> tfQuestions, List<QAQuestion> qaQuestion) {
		super();
		this.tpName = tpName;
		this.tpIllustrate = tpIllustrate;
		this.tpTerm = tpTerm;
		this.tpClass = tpClass;
		this.tpCreateName = tpCreateName;
		this.scQuestions = scQuestions;
		this.mcQuestions = mcQuestions;
		this.fbQuestions = fbQuestions;
		this.tfQuestions = tfQuestions;
		this.qaQuestion = qaQuestion;
	}
	public TestPaperView() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
