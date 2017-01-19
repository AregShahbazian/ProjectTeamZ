package com.teamz.web.rest;

import javax.inject.Inject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamz.domain.QuestionType;
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
		
		String movieId = questionService.getRandomMovieId();
		QuestionType qt = questionService.getRandomQuestionType();
		
		JSONObject totalQuestion = new JSONObject();
		String dQuestion = questionService.generate(movieId, qt);
		String[] aOptions = optionService.generateOptions(movieId, qt);

		try {
			totalQuestion.put("displayedQuestion", dQuestion);			
			totalQuestion.put("answerOptions", aOptions);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return totalQuestion.toString();
	}
	

	@PutMapping("/question/")
	private void sendResponse(@RequestBody String response){
		//still need to see how polymer sends request body 
		
		// TODO: handle response with service
	}

}
