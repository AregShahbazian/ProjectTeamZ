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
							"tt0317248", "tt0816692",
							"tt0109830", "tt0073486",
							"tt0102926", "tt0120586",
							"tt0082971", "tt0078788",
							"tt0110357", "tt0078748",
							"tt0405094", "tt1853728",
							"tt0169547", "tt0066921",
							"tt1065073", "tt3783958",
							"tt1392190", "tt3748528",
							"tt0088763", "tt0469116",
							"tt0338013", "tt0079470"};
		
		for (String movieId: movieIds) {
			
			Movie movie = new Movie();
		
			movie.setApiId(movieId);
			
			//save movie to db
			movieRepository.save(movie);
			
		}


		return;		
	}
	
}
