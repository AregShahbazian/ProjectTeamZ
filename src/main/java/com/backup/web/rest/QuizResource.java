package com.backup.web.rest;

import com.backup.service.QuizService;
import com.backup.web.rest.util.HeaderUtil;
import com.backup.service.dto.QuizDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Quiz.
 */
@RestController
public class QuizResource {

    private final Logger log = LoggerFactory.getLogger(QuizResource.class);
        
    @Inject
    private QuizService quizService;

    /**
     * POST  /quizzes : Create a new quiz.
     *
     * @param quizDTO the quizDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new quizDTO, or with status 400 (Bad Request) if the quiz has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/quizzes")
    public ResponseEntity<QuizDTO> createQuiz(@Valid @RequestBody QuizDTO quizDTO) throws URISyntaxException {
        log.debug("REST request to save Quiz : {}", quizDTO);
        if (quizDTO.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("quiz", "idexists", "A new quiz cannot already have an ID")).body(null);
        }
        QuizDTO result = quizService.save(quizDTO);
        return ResponseEntity.created(new URI("/api/quizzes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("quiz", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /quizzes : Updates an existing quiz.
     *
     * @param quizDTO the quizDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated quizDTO,
     * or with status 400 (Bad Request) if the quizDTO is not valid,
     * or with status 500 (Internal Server Error) if the quizDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/quizzes")
    public ResponseEntity<QuizDTO> updateQuiz(@Valid @RequestBody QuizDTO quizDTO) throws URISyntaxException {
        log.debug("REST request to update Quiz : {}", quizDTO);
        if (quizDTO.getId() == null) {
            return createQuiz(quizDTO);
        }
        QuizDTO result = quizService.save(quizDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("quiz", quizDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /quizzes : get all the quizzes.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of quizzes in body
     */
    @GetMapping("/quizzes")
    public List<QuizDTO> getAllQuizzes() {
        log.debug("REST request to get all Quizzes");
        return quizService.findAll();
    }

    /**
     * GET  /quizzes/:id : get the "id" quiz.
     *
     * @param id the id of the quizDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the quizDTO, or with status 404 (Not Found)
     */
    @GetMapping("/quizzes/{id}")
    public ResponseEntity<QuizDTO> getQuiz(@PathVariable Long id) {
        log.debug("REST request to get Quiz : {}", id);
        QuizDTO quizDTO = quizService.findOne(id);
        return Optional.ofNullable(quizDTO)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /quizzes/:id : delete the "id" quiz.
     *
     * @param id the id of the quizDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/quizzes/{id}")
    public ResponseEntity<Void> deleteQuiz(@PathVariable Long id) {
        log.debug("REST request to delete Quiz : {}", id);
        quizService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("quiz", id.toString())).build();
    }

}
