package com.teamz.service;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class QuestionService {

	public JSONObject generate(String apiId) {
		
		JSONObject movieJSON = getQuestionJson(apiId);
		
		return movieJSON;

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

}
