package com.teamz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teamz.domain.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

	// need perfect camel case, parameter must exactly match attribute in Movie
	Movie findOneByApiId(String apiId);

	@Query(value = "SELECT * FROM my_schema.movie order by rand() limit 1", nativeQuery = true)
	Movie getRandomMovie();
}
