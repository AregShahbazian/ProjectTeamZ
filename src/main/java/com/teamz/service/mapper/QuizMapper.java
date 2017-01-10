package com.teamz.service.mapper;

import com.teamz.domain.*;
import com.teamz.service.dto.QuizDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity Quiz and its DTO QuizDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface QuizMapper {

    QuizDTO quizToQuizDTO(Quiz quiz);

    List<QuizDTO> quizzesToQuizDTOs(List<Quiz> quizzes);

    @Mapping(target = "questions", ignore = true)
    Quiz quizDTOToQuiz(QuizDTO quizDTO);

    List<Quiz> quizDTOsToQuizzes(List<QuizDTO> quizDTOs);
}
