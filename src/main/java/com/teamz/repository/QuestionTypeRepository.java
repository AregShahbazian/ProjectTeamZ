package com.teamz.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.teamz.domain.QuestionType;

public interface QuestionTypeRepository extends JpaRepository<QuestionType, Long> {

	//List<QuestionType> findById(Long Id);
	
	@Query(value = "SELECT id, q_type, q_template FROM my_schema.question_type order by rand() limit 1", nativeQuery = true)
	QuestionType getRandomQuestionType();
	
}
