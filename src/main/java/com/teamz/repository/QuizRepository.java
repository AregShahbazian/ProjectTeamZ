package com.teamz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamz.domain.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>{
	
	public Quiz findOneById(long Id);
}
