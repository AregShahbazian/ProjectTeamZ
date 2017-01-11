package com.backup.service.mapper;

import com.backup.domain.*;
import com.backup.service.dto.QuestionTypeDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity QuestionType and its DTO QuestionTypeDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface QuestionTypeMapper {

    QuestionTypeDTO questionTypeToQuestionTypeDTO(QuestionType questionType);

    List<QuestionTypeDTO> questionTypesToQuestionTypeDTOs(List<QuestionType> questionTypes);

    @Mapping(target = "questions", ignore = true)
    QuestionType questionTypeDTOToQuestionType(QuestionTypeDTO questionTypeDTO);

    List<QuestionType> questionTypeDTOsToQuestionTypes(List<QuestionTypeDTO> questionTypeDTOs);
}
