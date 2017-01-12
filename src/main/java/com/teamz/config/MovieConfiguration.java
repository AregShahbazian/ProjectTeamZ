package com.teamz.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.teamz.repository.MovieRepository;

@Configuration
public class MovieConfiguration {

	
	@Inject
	private MovieRepository movieRepository;
	
	@Bean
	public Boolean foo(){
		
		
		
		
		return false;
		
	}
	
}
