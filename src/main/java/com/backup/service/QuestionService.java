package com.backup.service;

import com.backup.domain.Question;
import com.backup.repository.QuestionRepository;
import com.backup.service.dto.QuestionDTO;
import com.backup.service.mapper.QuestionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Question.
 */
@Service
@Transactional
public class QuestionService {

    private final Logger log = LoggerFactory.getLogger(QuestionService.class);
    
    @Inject
    private QuestionRepository questionRepository;

    @Inject
    private QuestionMapper questionMapper;

    /**
     * Save a question.
     *
     * @param questionDTO the entity to save
     * @return the persisted entity
     */
    public QuestionDTO save(QuestionDTO questionDTO) {
        log.debug("Request to save Question : {}", questionDTO);
        Question question = questionMapper.questionDTOToQuestion(questionDTO);
        question = questionRepository.save(question);
        QuestionDTO result = questionMapper.questionToQuestionDTO(question);
        return result;
    }

    /**
     *  Get all the questions.
     *  
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public List<QuestionDTO> findAll() {
        log.debug("Request to get all Questions");
        List<QuestionDTO> result = questionRepository.findAll().stream()
            .map(questionMapper::questionToQuestionDTO)
            .collect(Collectors.toCollection(LinkedList::new));

        return result;
    }

    /**
     *  Get one question by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public QuestionDTO findOne(Long id) {
        log.debug("Request to get Question : {}", id);
        Question question = questionRepository.findOne(id);
        QuestionDTO questionDTO = questionMapper.questionToQuestionDTO(question);
        return questionDTO;
    }
    
    @Transactional(readOnly = true) 
    public QuestionDTO generateNew(Long quizId) {
        log.debug("Request to get a new Question for Quiz : {}", quizId);
        
        // TODO: Use MovieService to get a random movie
        
        // TODO: Use QuestionTypeService to get a random question-type
        
        // TODO: Generate QuestionDTO using the movie-data and type
        
        QuestionDTO questionDTO = generateQuestion();
        Question question = questionMapper.questionDTOToQuestion(questionDTO);
        return questionDTO;
    }
    
    public QuestionDTO generateQuestion(/* Movie, Type */){
    	return new QuestionDTO();
    	
    }

    /**
     *  Delete the  question by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Question : {}", id);
        questionRepository.delete(id);
    }
}
