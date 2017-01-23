package com.teamz.web.rest;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamz.domain.Quiz;
import com.teamz.service.QuizService;

@CrossOrigin
@RestController
public class QuizController {

	@Inject
	QuizService quizService;

	@PostMapping("/quiz")
	public Quiz startQuiz() {
		return quizService.insertQuiz();
	}

	
}
