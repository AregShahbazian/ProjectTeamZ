package com.teamz.service.dto;

import java.util.ArrayList;

public class QuestionDTO {


	private String displayedQuestion;

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
	
	public void addAnswerOption(String answerOption){
		this.answerOptions.add(answerOption);
	}
	
	
}
