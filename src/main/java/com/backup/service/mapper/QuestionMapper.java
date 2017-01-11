package com.backup.service.mapper;

import com.backup.domain.*;
import com.backup.service.dto.QuestionDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity Question and its DTO QuestionDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface QuestionMapper {

    @Mapping(source = "quiz.id", target = "quizId")
    @Mapping(source = "questionType.id", target = "questionTypeId")
    QuestionDTO questionToQuestionDTO(Question question);

    List<QuestionDTO> questionsToQuestionDTOs(List<Question> questions);

    @Mapping(source = "quizId", target = "quiz")
    @Mapping(source = "questionTypeId", target = "questionType")
    Question questionDTOToQuestion(QuestionDTO questionDTO);

    List<Question> questionDTOsToQuestions(List<QuestionDTO> questionDTOs);

    default Quiz quizFromId(Long id) {
        if (id == null) {
            return null;
        }
        Quiz quiz = new Quiz();
        quiz.setId(id);
        return quiz;
    }

    default QuestionType questionTypeFromId(Long id) {
        if (id == null) {
            return null;
        }
        QuestionType questionType = new QuestionType();
        questionType.setId(id);
        return questionType;
    }
}
