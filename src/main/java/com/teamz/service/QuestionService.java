package com.teamz.service;

import javax.inject.Inject;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.teamz.domain.Movie;
import com.teamz.domain.Question;
import com.teamz.domain.QuestionType;
import com.teamz.repository.MovieRepository;
import com.teamz.repository.QuestionRepository;
import com.teamz.repository.QuestionTypeRepository;

@Service
public class QuestionService {

	@Inject 
	MovieRepository movieRepo;
	
	@Inject
	QuestionTypeRepository qtRepo;
	
	@Inject
	QuestionRepository questionRepo;
	
	public String generate(String movieId, QuestionType qt) {
		
		//get data from movie API
		JSONObject movieJSON = getQuestionJson(movieId);
		
		//get the question String
		String displayedQuestion = qt.getqTemplate();


		//replace the placeholder
		String title;
		try {
			title = movieJSON.get("Title").toString();
		} catch (JSONException e) {
			e.printStackTrace();
			title = "";
		}
		displayedQuestion = displayedQuestion.replace("#MovieNameZ", title);
		
		
		return displayedQuestion;

	}
	
	private JSONObject getQuestionJson(String apiId){
		
		RestTemplate restTemplate = new RestTemplate();
		String movie = restTemplate.getForObject("http://www.omdbapi.com/?i=" + apiId + "&plot=short&r=json", String.class);
		
		JSONObject jsonObject;
		
		try {
			jsonObject = new JSONObject(movie);
			//return the filled JSON if successful data retrieval
			return jsonObject;

		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		//return nothing if retrieval not successful
		return null;
	}
	
/*	public void saveResponse(Long Id, boolean correct) {
		
		Question question = questionRepo.findOneById(Id);
		question.setCorrectlyAnswered(correct);
		questionRepo.save(question);
	}
*/	
	//to generate random questions
	public Movie getRandomMovieId() {
		return movieRepo.getRandomMovie();
	}
	
	public QuestionType getRandomQuestionType() {
		return qtRepo.getRandomQuestionType();
	}
	
	private String formatJson(JSONObject json) {
		
		
		String display = "";
		
		if (json != null) {
			//terminate
		
			for (String k: JSONObject.getNames(json)) {
				
				try {
					
					display += k + " : "+ json.get(k) +"<br>";
					
				} catch (JSONException e) {
					e.printStackTrace();
					return "";
				}
				
			}
		} else return "";
		
		return display;
		
	}
	
	public Long saveQuestion(QuestionType questionType, Movie movie){
		Question question = new Question();
		question.setqMovie(movie);
		question.setqType(questionType);
		
		return questionRepo.save(question).getId();
		
	}
	
}
