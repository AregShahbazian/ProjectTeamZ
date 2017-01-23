package com.teamz.web.rest;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.teamz.domain.QuestionType;
import com.teamz.repository.QuizRepository;
import com.teamz.service.OptionService;
import com.teamz.service.QuestionService;
import com.teamz.service.dto.QuestionDTO;
import com.teamz.service.dto.ResponseDTO;

@CrossOrigin
@RestController
public class QuestionController {
	

	@Inject
	QuizRepository QuizRepo;
	
	@Inject
	OptionService optionService;
	
	@Inject
	QuestionService questionService;	

    @GetMapping("/question")
	public QuestionDTO getQuestion(){
		
		String movieId = questionService.getRandomMovieId();
		QuestionType qt = questionService.getRandomQuestionType();

		QuestionDTO totalQuestion = new QuestionDTO();
		totalQuestion.setDisplayedQuestion(questionService.generate(movieId, qt));
		totalQuestion.setAnswerOptions(optionService.generateOptions(movieId, qt));
		
		return totalQuestion;
	}
	

	@PutMapping("/question")
	private void sendResponse(@RequestBody ResponseDTO responseDTO){
		
		optionService.checkResponse(responseDTO.getResponse());
		
		// TODO: handle response with service
	}

}
