package com.teamz;

import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.teamz.domain.Movie;
import com.teamz.repository.MovieRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectTeamZApplicationTests {

	@Inject
	private MovieRepository movieRepo;

	@Test
	public void contextLoads() {

		Movie movie = new Movie();
		movie.setApiId("fooId");

		int sizeBefore = movieRepo.findAll().size();
		movieRepo.save(movie);
		int sizeAfter = movieRepo.findAll().size();

		assertTrue(sizeAfter == sizeBefore + 1);

	}
}
