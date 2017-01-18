package com.teamz.service;

import javax.inject.Inject;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class OptionService {
	
	@Inject QuestionService questionService;
	
	public JSONObject generateOptions(String rightAnswerApiId) {
		
		//TODO: ...
		return null;
	}
	
	public void checkResponse(String givenAnswer) {
		
		//TODO:
		//check the response
		//call save function to save response to DB
		
	}
	
	
}
