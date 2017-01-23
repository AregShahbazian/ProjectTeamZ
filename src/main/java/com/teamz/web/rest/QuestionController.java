package com.teamz.web.rest;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.teamz.domain.Movie;
import com.teamz.domain.QuestionType;
import com.teamz.repository.QuizRepository;
import com.teamz.service.OptionService;
import com.teamz.service.QuestionService;
import com.teamz.service.QuizService;
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

	@Inject
	QuizService quizService;

	@GetMapping("/question")
	public QuestionDTO getQuestion(@RequestParam(value = "quizId", required = true) Long quizId) {

		Movie movie = questionService.getRandomMovieId();
		QuestionType qt = questionService.getRandomQuestionType();

		QuestionDTO totalQuestion = new QuestionDTO();
		totalQuestion.setDisplayedQuestion(questionService.generate(movie.getApiId(), qt));
		totalQuestion.setAnswerOptions(optionService.generateOptions(movie.getApiId(), qt));

		totalQuestion.setId(questionService.saveQuestion(qt, movie));

		quizService.addQuestionToList(totalQuestion.getId(), quizId);

		return totalQuestion;
	}

	@PutMapping("/question")
	private void sendResponse(@Valid @RequestBody ResponseDTO responseDTO) {

		optionService.checkResponse(responseDTO.getQuestionId(), responseDTO.getResponse());

		// TODO: handle response with service

	}

}
