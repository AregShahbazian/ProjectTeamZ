package com.teamz.service;

import java.time.ZonedDateTime;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.teamz.domain.Quiz;
import com.teamz.repository.QuizRepository;

@Service
public class QuizService {
	
	@Inject //hibernate makes a class from the interface
	QuizRepository quizRepo;
	
	@Inject
	QuizService quizService;
	
	public void insertQuiz() {
		//add a new quiz to the database
		
		Quiz q = new Quiz();
		q.setStartedAt(ZonedDateTime.now());
		
		
		quizRepo.save(q);  
		
	}
	
	

}
