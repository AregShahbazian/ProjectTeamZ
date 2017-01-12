package com.teamz.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.teamz.domain.QuestionType;

public interface QuestionTypeRepository extends JpaRepository<QuestionType, Long> {

	List<QuestionType> findById(Long Id);
}
