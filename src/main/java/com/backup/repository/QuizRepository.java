package com.backup.repository;


import org.springframework.data.jpa.repository.*;

import com.backup.domain.Quiz;

import java.util.List;

/**
 * Spring Data JPA repository for the Quiz entity.
 */
@SuppressWarnings("unused")
public interface QuizRepository extends JpaRepository<Quiz,Long> {

}
