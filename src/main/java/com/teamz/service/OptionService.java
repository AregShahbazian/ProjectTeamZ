package com.teamz.service;

import javax.inject.Inject;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.teamz.domain.QuestionType;
import com.teamz.domain.Question;
import com.teamz.repository.QuestionRepository;


@Service
public class OptionService {
	
	@Inject QuestionService questionService;
	@Inject QuestionRepository questionRepo;
	
	private int numOptions = 4;
	
	public ArrayList<String> generateOptions(String rightAnswerApiId, QuestionType qt) {
		
		//return string list
		String[] answerOptionsArray = new String[numOptions];
		Set<String> answerOptionsSet = new HashSet<String>();
				
		//call for right answer
		RestTemplate restTemplate = new RestTemplate();
		String movie = restTemplate.getForObject("http://www.omdbapi.com/?i=" + rightAnswerApiId + "&plot=short&r=json", String.class);
		
		JSONObject apiJson;
		
		Random r = new Random();
		int posCorrectAnswer = r.nextInt(numOptions);
		
		try {
			apiJson = new JSONObject(movie);
			answerOptionsArray[posCorrectAnswer] = apiJson.get(qt.getqType()).toString();
			answerOptionsSet.add(apiJson.get(qt.getqType()).toString());
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		/*
		//random other answer options
		for (int i = 0; i < numOptions; i++){
			if (i != posCorrectAnswer) {
				//get another answer possibility
				movie = restTemplate.getForObject("http://www.omdbapi.com/?i=" + questionService.getRandomMovieId().getApiId() + "&plot=short&r=json", String.class);
				
				try {
					apiJson = new JSONObject(movie);
					answerOptionsTemp[i] = apiJson.get(qt.getqType()).toString();
				} catch (JSONException e) {
					e.printStackTrace();
				}
			
			}
			else continue;
			
		}*/
		
		//random other answer options
		int i = 0;
		while (i < numOptions){
			movie = restTemplate.getForObject("http://www.omdbapi.com/?i=" + questionService.getRandomMovieId().getApiId() + "&plot=short&r=json", String.class);
			try {
				apiJson = new JSONObject(movie);
				String answerOptionTemp = apiJson.get(qt.getqType()).toString();
				if (i != posCorrectAnswer && answerOptionsSet.add(answerOptionTemp)) {
					answerOptionsArray[i] = answerOptionTemp;
					i++;
				}
				else if (i == posCorrectAnswer){
					i++;
				}
				else continue;
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
				
		ArrayList<String> answerOptions = new ArrayList<String>(Arrays.asList(answerOptionsArray));
		return answerOptions;
	}
	
	public void checkResponse(long questionId, String givenAnswer) {
		
		//call for right answer
		RestTemplate restTemplate = new RestTemplate();
		String apiMovieId = questionRepo.findOneById(questionId).getqMovie().getApiId();
		String movie = restTemplate.getForObject("http://www.omdbapi.com/?i=" + apiMovieId + "&plot=short&r=json", String.class);
		
		JSONObject apiJson;
		try {
			apiJson = new JSONObject(movie);
			Question question = questionRepo.findOneById(questionId);
			//check the response
			question.setCorrectlyAnswered(givenAnswer.equals(apiJson.get(question.getqType().getqType()).toString()));
			questionRepo.save(question);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	
}
