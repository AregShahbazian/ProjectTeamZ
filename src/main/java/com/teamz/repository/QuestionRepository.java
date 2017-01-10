package com.teamz.repository;


import org.springframework.data.jpa.repository.*;

import com.teamz.domain.Question;

import java.util.List;

/**
 * Spring Data JPA repository for the Question entity.
 */
@SuppressWarnings("unused")
public interface QuestionRepository extends JpaRepository<Question,Long> {

}
