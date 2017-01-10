package com.teamz.service;

import com.teamz.domain.Quiz;
import com.teamz.repository.QuizRepository;
import com.teamz.service.dto.QuizDTO;
import com.teamz.service.mapper.QuizMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Quiz.
 */
@Service
@Transactional
public class QuizService {

    private final Logger log = LoggerFactory.getLogger(QuizService.class);
    
    @Inject
    private QuizRepository quizRepository;

    @Inject
    private QuizMapper quizMapper;

    /**
     * Save a quiz.
     *
     * @param quizDTO the entity to save
     * @return the persisted entity
     */
    public QuizDTO save(QuizDTO quizDTO) {
        log.debug("Request to save Quiz : {}", quizDTO);
        Quiz quiz = quizMapper.quizDTOToQuiz(quizDTO);
        quiz = quizRepository.save(quiz);
        QuizDTO result = quizMapper.quizToQuizDTO(quiz);
        return result;
    }

    /**
     *  Get all the quizzes.
     *  
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public List<QuizDTO> findAll() {
        log.debug("Request to get all Quizzes");
        List<QuizDTO> result = quizRepository.findAll().stream()
            .map(quizMapper::quizToQuizDTO)
            .collect(Collectors.toCollection(LinkedList::new));

        return result;
    }

    /**
     *  Get one quiz by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public QuizDTO findOne(Long id) {
        log.debug("Request to get Quiz : {}", id);
        Quiz quiz = quizRepository.findOne(id);
        QuizDTO quizDTO = quizMapper.quizToQuizDTO(quiz);
        return quizDTO;
    }

    /**
     *  Delete the  quiz by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Quiz : {}", id);
        quizRepository.delete(id);
    }
}
