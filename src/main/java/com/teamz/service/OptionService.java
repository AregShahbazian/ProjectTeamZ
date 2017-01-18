package com.teamz.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.teamz.domain.QuestionType;

@Service
public class OptionService {
	
	@Inject QuestionService questionService;
	
	public String[] generateOptions(String rightAnswerApiId, QuestionType qt) {
		
		//TODO: ...
		return null;
	}
	
	public void checkResponse(String givenAnswer) {
		
		//TODO:
		//check the response
		//call save function to save response to DB
		
	}
	
	
}
