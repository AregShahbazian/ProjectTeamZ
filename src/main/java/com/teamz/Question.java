package com.teamz;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

public class Question {

	private enum qType {
		year, director, awards
	};

	// stuff
	


	public String generate() {
		
		String apiId = "tt0138";
		JSONObject movieJSON = getQuestionJson(apiId);
		
		String display = "";
		
		if (movieJSON != null) {
			//terminate
		
			for (String k: JSONObject.getNames(movieJSON)) {
				
				try {
					
					display += k + " : "+ movieJSON.get(k) +"<br>";
					
				} catch (JSONException e) {
					e.printStackTrace();
				}
				
			}
		}
		
		return display;

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
