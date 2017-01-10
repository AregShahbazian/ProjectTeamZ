package com.teamz.repository;


import org.springframework.data.jpa.repository.*;

import com.teamz.domain.QuestionType;

import java.util.List;

/**
 * Spring Data JPA repository for the QuestionType entity.
 */
@SuppressWarnings("unused")
public interface QuestionTypeRepository extends JpaRepository<QuestionType,Long> {

}
