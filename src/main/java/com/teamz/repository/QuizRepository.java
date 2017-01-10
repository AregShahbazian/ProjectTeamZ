package com.teamz.repository;


import org.springframework.data.jpa.repository.*;

import com.teamz.domain.Quiz;

import java.util.List;

/**
 * Spring Data JPA repository for the Quiz entity.
 */
@SuppressWarnings("unused")
public interface QuizRepository extends JpaRepository<Quiz,Long> {

}
