package com.teamz.web.rest;

import com.teamz.service.QuestionTypeService;
import com.teamz.web.rest.util.HeaderUtil;
import com.teamz.service.dto.QuestionTypeDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for managing QuestionType.
 */
@RestController
@RequestMapping("/api")
public class QuestionTypeResource {

    private final Logger log = LoggerFactory.getLogger(QuestionTypeResource.class);
        
    @Inject
    private QuestionTypeService questionTypeService;

    /**
     * POST  /question-types : Create a new questionType.
     *
     * @param questionTypeDTO the questionTypeDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new questionTypeDTO, or with status 400 (Bad Request) if the questionType has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/question-types")
    public ResponseEntity<QuestionTypeDTO> createQuestionType(@Valid @RequestBody QuestionTypeDTO questionTypeDTO) throws URISyntaxException {
        log.debug("REST request to save QuestionType : {}", questionTypeDTO);
        if (questionTypeDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("questionType", "idexists", "A new questionType cannot already have an ID")).body(null);
        }
        QuestionTypeDTO result = questionTypeService.save(questionTypeDTO);
        return ResponseEntity.created(new URI("/api/question-types/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("questionType", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /question-types : Updates an existing questionType.
     *
     * @param questionTypeDTO the questionTypeDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated questionTypeDTO,
     * or with status 400 (Bad Request) if the questionTypeDTO is not valid,
     * or with status 500 (Internal Server Error) if the questionTypeDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/question-types")
    public ResponseEntity<QuestionTypeDTO> updateQuestionType(@Valid @RequestBody QuestionTypeDTO questionTypeDTO) throws URISyntaxException {
        log.debug("REST request to update QuestionType : {}", questionTypeDTO);
        if (questionTypeDTO.getId() == null) {
            return createQuestionType(questionTypeDTO);
        }
        QuestionTypeDTO result = questionTypeService.save(questionTypeDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("questionType", questionTypeDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /question-types : get all the questionTypes.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of questionTypes in body
     */
    @GetMapping("/question-types")
    public List<QuestionTypeDTO> getAllQuestionTypes() {
        log.debug("REST request to get all QuestionTypes");
        return questionTypeService.findAll();
    }

    /**
     * GET  /question-types/:id : get the "id" questionType.
     *
     * @param id the id of the questionTypeDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the questionTypeDTO, or with status 404 (Not Found)
     */
    @GetMapping("/question-types/{id}")
    public ResponseEntity<QuestionTypeDTO> getQuestionType(@PathVariable Long id) {
        log.debug("REST request to get QuestionType : {}", id);
        QuestionTypeDTO questionTypeDTO = questionTypeService.findOne(id);
        return Optional.ofNullable(questionTypeDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /question-types/:id : delete the "id" questionType.
     *
     * @param id the id of the questionTypeDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/question-types/{id}")
    public ResponseEntity<Void> deleteQuestionType(@PathVariable Long id) {
        log.debug("REST request to delete QuestionType : {}", id);
        questionTypeService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("questionType", id.toString())).build();
    }

}
