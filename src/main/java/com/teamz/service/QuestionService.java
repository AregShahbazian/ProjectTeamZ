package com.teamz.service;

import javax.inject.Inject;

import org.json.JSONException;


import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.teamz.domain.QuestionType;
import com.teamz.repository.MovieRepository;
import com.teamz.repository.QuestionTypeRepository;

@Service
public class QuestionService {

	@Inject 
	MovieRepository movieRepo;
	
	@Inject
	QuestionTypeRepository qtRepo;
	
	public String generate() {
		
		//get data from movie API
		String movieId = movieRepo.getRandomMovie();
		JSONObject movieJSON = getQuestionJson(movieId);
		
		//get the question String
		QuestionType qt = qtRepo.getRandomQuestionType();
		String displayedQuestion = qt.getqTemplate();
		
		
		//replace the placeholder
		String title;
		try {
			title = movieJSON.get("Title").toString();
		} catch (JSONException e) {
			e.printStackTrace();
			title = "";
		}
		displayedQuestion = displayedQuestion.replace("#MovieNameZ", title);
		
		
		return displayedQuestion + "<br><br>" + formatJson(movieJSON);

	}
	
	private JSONObject getQuestionJson(String apiId){
		
		RestTemplate restTemplate = new RestTemplate();
		String movie = restTemplate.getForObject("http://www.omdbapi.com/?i=" + apiId + "&plot=short&r=json", String.class);
		
		JSONObject jsonObject;
		
		try {
			jsonObject = new JSONObject(movie);
			//return the filled JSON if successful data retrieval
			return jsonObject;

		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		//return nothing if retrieval not successful
		return null;
	}
	
	public void saveResponse(boolean correct ) {
		
		//TODO: use repo to save response
	}
	
	
	private String formatJson(JSONObject json) {
		
		
		String display = "";
		
		if (json != null) {
			//terminate
		
			for (String k: JSONObject.getNames(json)) {
				
				try {
					
					display += k + " : "+ json.get(k) +"<br>";
					
				} catch (JSONException e) {
					e.printStackTrace();
					return "";
				}
				
			}
		} else return "";
		
		return display;
		
	}
}
