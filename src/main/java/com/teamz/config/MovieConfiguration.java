package com.teamz.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;

import com.teamz.domain.Movie;
import com.teamz.repository.MovieRepository;

@Configuration
public class MovieConfiguration {

	@Inject
	private MovieRepository movieRepository;
	
	@Inject
	public void buildMovieRepo(){
		

		String[] movieIds = {"tt0111161","tt0068646",
							"tt0468569","tt0050083",
							"tt0110912","tt0120737",
							"tt0317248", "tt0816692"};
		
		for (String movieId: movieIds) {
			
			Movie movie = new Movie();
		
			movie.setApiId(movieId);
			
			//save movie to db
			movieRepository.save(movie);
			
		}


		return;		
	}
	
}
