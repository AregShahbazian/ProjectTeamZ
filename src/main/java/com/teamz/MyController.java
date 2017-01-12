package com.teamz;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamz.repository.MovieRepository;

@RestController
public class MyController {
	
	@Inject 
	MovieRepository movieRepo;
	
	@RequestMapping("quiz")
	public String post() {
		
		String display;
		
		Question q1 = new Question();
		
		String movieId = movieRepo.getRandomMovie();
				
		display = q1.generate(movieId);
		
		return display;
	}

}
