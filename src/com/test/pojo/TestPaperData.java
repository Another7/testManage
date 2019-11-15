package com.test.pojo;

public class TestPaperData {

	
	private String tpName;
	private String tpIllustrate;
	private String tpTerm;
	private String tpClass;
	private QuestionLevelNumber scNumber;
	private QuestionLevelNumber mcNumber;
	private QuestionLevelNumber fbNumber;
	private QuestionLevelNumber tfNumber;
	@Override
	public String toString() {
		return "TestPaperData [tpName=" + tpName + ", tpIllustrate=" + tpIllustrate + ", tpTerm=" + tpTerm
				+ ", tpClass=" + tpClass + ", scNumber=" + scNumber + ", mcNumber=" + mcNumber + ", fbNumber="
				+ fbNumber + ", tfNumber=" + tfNumber + ", qaNumber=" + qaNumber + "]";
	}
	public TestPaperData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestPaperData(String tpName, String tpIllustrate, String tpTerm, String tpClass,
			QuestionLevelNumber scNumber, QuestionLevelNumber mcNumber, QuestionLevelNumber fbNumber,
			QuestionLevelNumber tfNumber, QuestionLevelNumber qaNumber) {
		super();
		this.tpName = tpName;
		this.tpIllustrate = tpIllustrate;
		this.tpTerm = tpTerm;
		this.tpClass = tpClass;
		this.scNumber = scNumber;
		this.mcNumber = mcNumber;
		this.fbNumber = fbNumber;
		this.tfNumber = tfNumber;
		this.qaNumber = qaNumber;
	}
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
	public QuestionLevelNumber getScNumber() {
		return scNumber;
	}
	public void setScNumber(QuestionLevelNumber scNumber) {
		this.scNumber = scNumber;
	}
	public QuestionLevelNumber getMcNumber() {
		return mcNumber;
	}
	public void setMcNumber(QuestionLevelNumber mcNumber) {
		this.mcNumber = mcNumber;
	}
	public QuestionLevelNumber getFbNumber() {
		return fbNumber;
	}
	public void setFbNumber(QuestionLevelNumber fbNumber) {
		this.fbNumber = fbNumber;
	}
	public QuestionLevelNumber getTfNumber() {
		return tfNumber;
	}
	public void setTfNumber(QuestionLevelNumber tfNumber) {
		this.tfNumber = tfNumber;
	}
	public QuestionLevelNumber getQaNumber() {
		return qaNumber;
	}
	public void setQaNumber(QuestionLevelNumber qaNumber) {
		this.qaNumber = qaNumber;
	}
	private QuestionLevelNumber qaNumber;
}
