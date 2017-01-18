package com.teamz.web.rest;

import javax.inject.Inject;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamz.domain.QuestionType;
import com.teamz.repository.MovieRepository;
import com.teamz.repository.QuestionTypeRepository;
import com.teamz.repository.QuizRepository;
import com.teamz.service.OptionService;
import com.teamz.service.QuestionService;

@RestController
public class QuestionController {
	

	@Inject
	QuizRepository QuizRepo;
	
	@Inject
	OptionService optionService;
	
	@Inject
	QuestionService questionService;
	
	
	@GetMapping("/question/")
	public String getQuestion() {
		
		// TODO: Include the options in the response as JSON
		return questionService.generate();
	}
	

	@PutMapping("/question/")
	private void sendResponse(@RequestBody String response){
		//still need to see how polymer sends request body 
		
		// TODO: handle response with service
	}

}
