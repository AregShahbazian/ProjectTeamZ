package com.teamz;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamz.domain.QuestionType;
import com.teamz.repository.MovieRepository;
import com.teamz.repository.QuestionTypeRepository;

@RestController
public class MyController {
	
	@Inject 
	MovieRepository movieRepo;
	
	@Inject
	QuestionTypeRepository qtRepo;
	
	@RequestMapping("quiz")
	public String post() {
		
		String display;
		
		Question q1 = new Question();
		
		String movieId = movieRepo.getRandomMovie();
				
		display = q1.generate(movieId);
				
		
		QuestionType qt = qtRepo.getRandomQuestionType();
		String displayQt = qt.getqTemplate();
				
		return displayQt + "<br><br>" + display;
	}

}
