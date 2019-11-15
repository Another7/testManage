package com.test.po;

public class TestPaperView {

	
	private String tpName;
	private String tpIllustrate;
	private String tpTerm;
	private String tpClass;
	private String tpCreateName;//创建者姓名
	private SCQuestion scQuestion;
	private MCQuestion mcQuestion;
	private FBQuestion fbQuestion;
	private TFQuestion tfQuestion;
	private QAQuestion qaQuestion;
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
	public SCQuestion getScQuestion() {
		return scQuestion;
	}
	public void setScQuestion(SCQuestion scQuestion) {
		this.scQuestion = scQuestion;
	}
	public MCQuestion getMcQuestion() {
		return mcQuestion;
	}
	public void setMcQuestion(MCQuestion mcQuestion) {
		this.mcQuestion = mcQuestion;
	}
	public FBQuestion getFbQuestion() {
		return fbQuestion;
	}
	public void setFbQuestion(FBQuestion fbQuestion) {
		this.fbQuestion = fbQuestion;
	}
	public TFQuestion getTfQuestion() {
		return tfQuestion;
	}
	public void setTfQuestion(TFQuestion tfQuestion) {
		this.tfQuestion = tfQuestion;
	}
	public QAQuestion getQaQuestion() {
		return qaQuestion;
	}
	public void setQaQuestion(QAQuestion qaQuestion) {
		this.qaQuestion = qaQuestion;
	}
	@Override
	public String toString() {
		return "TestPaperView [tpName=" + tpName + ", tpIllustrate=" + tpIllustrate + ", tpTerm=" + tpTerm
				+ ", tpClass=" + tpClass + ", tpCreateName=" + tpCreateName + ", scQuestion=" + scQuestion
				+ ", mcQuestion=" + mcQuestion + ", fbQuestion=" + fbQuestion + ", tfQuestion=" + tfQuestion
				+ ", qaQuestion=" + qaQuestion + "]";
	}
	public TestPaperView(String tpName, String tpIllustrate, String tpTerm, String tpClass, String tpCreateName,
			SCQuestion scQuestion, MCQuestion mcQuestion, FBQuestion fbQuestion, TFQuestion tfQuestion,
			QAQuestion qaQuestion) {
		super();
		this.tpName = tpName;
		this.tpIllustrate = tpIllustrate;
		this.tpTerm = tpTerm;
		this.tpClass = tpClass;
		this.tpCreateName = tpCreateName;
		this.scQuestion = scQuestion;
		this.mcQuestion = mcQuestion;
		this.fbQuestion = fbQuestion;
		this.tfQuestion = tfQuestion;
		this.qaQuestion = qaQuestion;
	}
	public TestPaperView() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
