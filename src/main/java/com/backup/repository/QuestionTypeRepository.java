package com.backup.repository;


import org.springframework.data.jpa.repository.*;

import com.backup.domain.QuestionType;

import java.util.List;

/**
 * Spring Data JPA repository for the QuestionType entity.
 */
@SuppressWarnings("unused")
public interface QuestionTypeRepository extends JpaRepository<QuestionType,Long> {

}
