package com.teamz.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.teamz.domain.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long>{
	
	//need perfect camel case, parameter must exactly match attribute in Movie
	List<Movie> findByApiId(String apiId);
	
}
