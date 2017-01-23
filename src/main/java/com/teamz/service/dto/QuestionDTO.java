package com.teamz.service.dto;

import java.util.ArrayList;

public class QuestionDTO {

	private Long id;

	private String displayedQuestion;
	
	private Integer questionNumber;

	private ArrayList<String> answerOptions = new ArrayList<>();

	public String getDisplayedQuestion() {
		return displayedQuestion;
	}

	public void setDisplayedQuestion(String displayedQuestion) {
		this.displayedQuestion = displayedQuestion;
	}

	public ArrayList<String> getAnswerOptions() {
		return answerOptions;
	}

	public void setAnswerOptions(ArrayList<String> answerOptions) {
		this.answerOptions = answerOptions;
	}

	public void addAnswerOption(String answerOption) {
		this.answerOptions.add(answerOption);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(Integer questionNumber) {
		this.questionNumber = questionNumber;
	}

}
