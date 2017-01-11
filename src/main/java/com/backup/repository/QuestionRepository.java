package com.backup.repository;


import org.springframework.data.jpa.repository.*;

import com.backup.domain.Question;

import java.util.List;

/**
 * Spring Data JPA repository for the Question entity.
 */
@SuppressWarnings("unused")
public interface QuestionRepository extends JpaRepository<Question,Long> {

}
