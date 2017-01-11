package com.backup.service;

import com.backup.domain.QuestionType;
import com.backup.repository.QuestionTypeRepository;
import com.backup.service.dto.QuestionTypeDTO;
import com.backup.service.mapper.QuestionTypeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing QuestionType.
 */
@Service
@Transactional
public class QuestionTypeService {

    private final Logger log = LoggerFactory.getLogger(QuestionTypeService.class);
    
    @Inject
    private QuestionTypeRepository questionTypeRepository;

    @Inject
    private QuestionTypeMapper questionTypeMapper;

    /**
     * Save a questionType.
     *
     * @param questionTypeDTO the entity to save
     * @return the persisted entity
     */
    public QuestionTypeDTO save(QuestionTypeDTO questionTypeDTO) {
        log.debug("Request to save QuestionType : {}", questionTypeDTO);
        QuestionType questionType = questionTypeMapper.questionTypeDTOToQuestionType(questionTypeDTO);
        questionType = questionTypeRepository.save(questionType);
        QuestionTypeDTO result = questionTypeMapper.questionTypeToQuestionTypeDTO(questionType);
        return result;
    }

    /**
     *  Get all the questionTypes.
     *  
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public List<QuestionTypeDTO> findAll() {
        log.debug("Request to get all QuestionTypes");
        List<QuestionTypeDTO> result = questionTypeRepository.findAll().stream()
            .map(questionTypeMapper::questionTypeToQuestionTypeDTO)
            .collect(Collectors.toCollection(LinkedList::new));

        return result;
    }

    /**
     *  Get one questionType by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public QuestionTypeDTO findOne(Long id) {
        log.debug("Request to get QuestionType : {}", id);
        QuestionType questionType = questionTypeRepository.findOne(id);
        QuestionTypeDTO questionTypeDTO = questionTypeMapper.questionTypeToQuestionTypeDTO(questionType);
        return questionTypeDTO;
    }

    /**
     *  Delete the  questionType by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete QuestionType : {}", id);
        questionTypeRepository.delete(id);
    }
}
