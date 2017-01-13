package com.teamz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teamz.domain.Question;


public interface QuestionRepository extends JpaRepository<Question, Long>{
	
	public Question findOneById(long Id);
	
}
