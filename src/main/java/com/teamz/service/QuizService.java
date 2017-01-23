package com.teamz.service;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.teamz.domain.Question;
import com.teamz.domain.Quiz;
import com.teamz.repository.QuestionRepository;
import com.teamz.repository.QuizRepository;

@Service
public class QuizService {

	@Inject // hibernate makes a class from the interface
	QuizRepository quizRepo;

	@Inject
	QuizService quizService;

	@Inject
	QuestionRepository questionRepo;

	public Quiz insertQuiz() {
		// add a new quiz to the database

		Quiz q = new Quiz();
		q.setStartedAt(new Date());
		q.setCounter(0);

		return quizRepo.save(q);

	}

	public Integer addQuestionToList(Long questionId, Long quizId) {
		// add a new question to the quiz

		Quiz quiz = quizRepo.findOneById(quizId);
		Question newQuestion = questionRepo.findOneById(questionId);
		quiz.add(newQuestion);
		quiz.setCounter(quiz.getCounter() + 1);
		quizRepo.save(quiz);
		return quiz.getQuestions().size();
	}

	public Quiz getQuizById(Long id) {
		return quizRepo.findOneById(id);
	}

}
