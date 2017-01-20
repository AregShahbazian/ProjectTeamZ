package com.teamz.service;

import java.time.ZonedDateTime;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.teamz.domain.Question;
import com.teamz.domain.Quiz;
import com.teamz.repository.QuizRepository;
import com.teamz.repository.QuestionRepository;

@Service
public class QuizService {
	
	@Inject //hibernate makes a class from the interface
	QuizRepository quizRepo;
	
	@Inject
	QuizService quizService;
	
	@Inject
	QuestionRepository questionRepo;
	
	public void insertQuiz() {
		//add a new quiz to the database
		
		Quiz q = new Quiz();
		q.setStartedAt(ZonedDateTime.now());
		
		
		quizRepo.save(q);  
		
	}
	
	public void addQuestionToList(Long questionId, Long quizId){
		// add a new question to the quiz
				
		Quiz q = quizRepo.findOneById(quizId);
		Question newQuestion = questionRepo.findOneById(questionId);
		q.add(newQuestion);
		quizRepo.save(q);
	}
}
