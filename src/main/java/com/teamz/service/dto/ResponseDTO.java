package com.teamz.service.dto;

import javax.validation.constraints.NotNull;

public class ResponseDTO {

	@NotNull
	private Long quizId;
	
	@NotNull
	private Long questionId;

	@NotNull
	private String response;

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

}
