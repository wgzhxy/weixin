package com.weixin.datacore.domain.weixin.model;

import java.io.Serializable;
/**
 * WeixinQuestion entity. @author MyEclipse Persistence Tools
 */
public class WeixinQuestion implements Serializable {
	
	private static final long serialVersionUID = -1865131623767882746L;
	private Long id;
	private String question;
	private String choiceA;
	private String choiceB;
	private String choiceC;
	private String choiceD;
	private String answer;
	private String prompt;
	private Integer quesDifficult;
	private String quesType;
	private String imgUrl;

	// Constructors

	/** default constructor */
	public WeixinQuestion() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getChoiceA() {
		return choiceA;
	}

	public void setChoiceA(String choiceA) {
		this.choiceA = choiceA;
	}

	public String getChoiceB() {
		return choiceB;
	}

	public void setChoiceB(String choiceB) {
		this.choiceB = choiceB;
	}

	public String getChoiceC() {
		return choiceC;
	}

	public void setChoiceC(String choiceC) {
		this.choiceC = choiceC;
	}

	public String getChoiceD() {
		return choiceD;
	}

	public void setChoiceD(String choiceD) {
		this.choiceD = choiceD;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getPrompt() {
		return prompt;
	}

	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}

	public Integer getQuesDifficult() {
		return quesDifficult;
	}

	public void setQuesDifficult(Integer quesDifficult) {
		this.quesDifficult = quesDifficult;
	}

	public String getQuesType() {
		return quesType;
	}

	public void setQuesType(String quesType) {
		this.quesType = quesType;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}