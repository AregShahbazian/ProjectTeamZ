package com.teamz.service;

import javax.inject.Inject;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.teamz.domain.QuestionType;

@Service
public class OptionService {
	
	@Inject QuestionService questionService;
	
	private int numOptions = 4;
	
	public ArrayList<String> generateOptions(String rightAnswerApiId, QuestionType qt) {
		
		//return string list
		String[] answerOptionsTemp = new String[numOptions];
		
		//call for right answer
		RestTemplate restTemplate = new RestTemplate();
		String movie = restTemplate.getForObject("http://www.omdbapi.com/?i=" + rightAnswerApiId + "&plot=short&r=json", String.class);
		
		JSONObject apiJson;
		
		Random r = new Random();
		int posCorrectAnswer = r.nextInt(numOptions);
		
		try {
			apiJson = new JSONObject(movie);
			answerOptionsTemp[posCorrectAnswer] = apiJson.get(qt.getqType()).toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		//random other answer options
		for (int i = 0; i < numOptions; i++){
			if (i != posCorrectAnswer) {
				//get another answer possibility
				movie = restTemplate.getForObject("http://www.omdbapi.com/?i=" + questionService.getRandomMovieId() + "&plot=short&r=json", String.class);
				
				try {
					apiJson = new JSONObject(movie);
					answerOptionsTemp[i] = apiJson.get(qt.getqType()).toString();
				} catch (JSONException e) {
					e.printStackTrace();
				}
			
			}
			else continue;
			
		}
		ArrayList<String> answerOptions = new ArrayList<String>(Arrays.asList(answerOptionsTemp));
		return answerOptions;
	}
	
	public void checkResponse(String givenAnswer) {
		
		//TODO:
		//check the response
		//call save function to save response to DB
		
	}
	
	
}
