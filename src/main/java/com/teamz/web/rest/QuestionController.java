package com.teamz.web.rest;

import javax.inject.Inject;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamz.domain.QuestionType;
import com.teamz.repository.MovieRepository;
import com.teamz.repository.QuestionTypeRepository;
import com.teamz.service.QuestionService;

@RestController
public class QuestionController {
	
	@Inject 
	MovieRepository movieRepo;
	
	@Inject
	QuestionTypeRepository qtRepo;
	
	@Inject
	QuestionService questionService;
	
	@RequestMapping("/question/")
	public String post() {
		
		JSONObject questionJson;
		
		String movieId = movieRepo.getRandomMovie();
				
		questionJson = questionService.generate(movieId);
		
		//get the question String
		QuestionType qt = qtRepo.getRandomQuestionType();
		String displayQt = qt.getqTemplate();
		
		//replace the placeholder
		String title;
		try {
			title = questionJson.get("Title").toString();
		} catch (JSONException e) {
			e.printStackTrace();
			title = "";
		}
		displayQt = displayQt.replace("#MovieNameZ", title);
				
		return displayQt + "<br><br>" + formatJson(questionJson);
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
