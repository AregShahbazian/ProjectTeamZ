package com.teamz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamz.domain.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	
	//need perfect camel case, parameter must exactly match attribute in Movie
	List<Movie> findByApiId(String apiId);
	
}
