package com.teamz.web.rest;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamz.domain.Quiz;
import com.teamz.service.QuizService;
import com.teamz.service.dto.QuizDTO;

@CrossOrigin
@RestController
public class QuizController {

	@Inject
	QuizService quizService;

	@PostMapping("/quiz")
	public QuizDTO startQuiz() {
		Quiz quiz = quizService.insertQuiz();

		QuizDTO quizDTO = new QuizDTO();
		quizDTO.setId(quiz.getId());
		quizDTO.setStartedAt(quiz.getStartedAt());
		quizDTO.setEndedAt(quiz.getEndedAt());
		return quizDTO;
	}

}
