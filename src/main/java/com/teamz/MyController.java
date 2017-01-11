package com.teamz;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {

	
	@RequestMapping("quiz")
	public String post(){
		
		RestTemplate restTemplate = new RestTemplate();
		String movie = restTemplate.getForObject("http://www.omdbapi.com/?i=tt0120338&plot=short&r=json", String.class);
		JSONObject jsonObject= new JSONObject(movie);
		System.out.println(movie.toString());
		
		return jsonObject.toString();
	}

}
