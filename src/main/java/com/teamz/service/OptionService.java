package com.teamz.service;

import javax.inject.Inject;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Random;

import com.teamz.domain.QuestionType;

@Service
public class OptionService {
	
	@Inject QuestionService questionService;
	
	private int numOptions = 4;
	
	public String[] generateOptions(String rightAnswerApiId, QuestionType qt) {
		
		//return string
		String[] answerOptions = new String[numOptions];
		
		//call for right answer
		RestTemplate restTemplate = new RestTemplate();
		String movie = restTemplate.getForObject("http://www.omdbapi.com/?i=" + rightAnswerApiId + "&plot=short&r=json", String.class);
		
		JSONObject apiJson;
		
		Random r = new Random();
		int posCorrectAnswer = r.nextInt(numOptions);
		
		try {
			apiJson = new JSONObject(movie);
			answerOptions[posCorrectAnswer] = apiJson.get(qt.getqType()).toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		//random other answer options
		for (int i = 0; i < answerOptions.length; i++){
			if (i != posCorrectAnswer) {
				//get another answer possibility
				movie = restTemplate.getForObject("http://www.omdbapi.com/?i=" + questionService.getRandomMovieId() + "&plot=short&r=json", String.class);
				
				try {
					apiJson = new JSONObject(movie);
					answerOptions[i] = apiJson.get(qt.getqType()).toString();
				} catch (JSONException e) {
					e.printStackTrace();
				}
			
			}
			else continue;
		}
		
		return answerOptions;
	}
	
	public void checkResponse(String givenAnswer) {
		
		//TODO:
		//check the response
		//call save function to save response to DB
		
	}
	
	
}
