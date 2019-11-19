package com.test.pojo;

import java.util.Arrays;

public class TestPaperData {

	private String tpName;
	private String tpIllustrate;
	private String tpTerm;
	private String tpClass;
	private Integer tpScore;
	private String tpMajor;
	private QuestionLevelNumber scNumber;
	private QuestionLevelNumber mcNumber;
	private QuestionLevelNumber fbNumber;
	private QuestionLevelNumber tfNumber;
	private QuestionLevelNumber qaNumber;
	private String[] chapterIds;

	public TestPaperData() {
		super();
	}

	public TestPaperData(String tpName, String tpIllustrate, String tpTerm, String tpClass,
			QuestionLevelNumber scNumber, QuestionLevelNumber mcNumber, QuestionLevelNumber fbNumber,
			QuestionLevelNumber tfNumber, QuestionLevelNumber qaNumber, String[] chapterIds, Integer tpScore,
			String tpMajor) {
		super();
		this.tpName = tpName;
		this.tpIllustrate = tpIllustrate;
		this.tpTerm = tpTerm;
		this.tpClass = tpClass;
		this.tpScore = tpScore;
		this.tpMajor = tpMajor;
		this.scNumber = scNumber;
		this.mcNumber = mcNumber;
		this.fbNumber = fbNumber;
		this.tfNumber = tfNumber;
		this.qaNumber = qaNumber;
		this.chapterIds = chapterIds;
	}

	public String[] getChapterIds() {
		return chapterIds;
	}

	public void setChapterIds(String[] chapterIds) {
		this.chapterIds = chapterIds;
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

	public Integer getTpScore() {
		return tpScore;
	}

	public void setTpScore(Integer tpScore) {
		this.tpScore = tpScore;
	}

	public String getTpMajor() {
		return tpMajor;
	}

	public void setTpMajor(String tpMajor) {
		this.tpMajor = tpMajor;
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

	@Override
	public String toString() {
		return "TestPaperData [tpName=" + tpName + ", tpIllustrate=" + tpIllustrate + ", tpTerm=" + tpTerm
				+ ", tpClass=" + tpClass + ", tpScore=" + tpScore + ", tpMajor=" + tpMajor + ", scNumber=" + scNumber
				+ ", mcNumber=" + mcNumber + ", fbNumber=" + fbNumber + ", tfNumber=" + tfNumber + ", qaNumber="
				+ qaNumber + ", chapterIds=" + Arrays.toString(chapterIds) + "]";
	}

}
