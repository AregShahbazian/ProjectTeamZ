package com.teamz;

import javax.inject.Inject;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamz.domain.QuestionType;
import com.teamz.repository.MovieRepository;
import com.teamz.repository.QuestionTypeRepository;

@RestController
public class MyController {
	
	@Inject 
	MovieRepository movieRepo;
	
	@Inject
	QuestionTypeRepository qtRepo;
	
	@RequestMapping("quiz")
	public String post() {
		
		JSONObject questionJson;
		
		Question q1 = new Question();
		
		String movieId = movieRepo.getRandomMovie();
				
		questionJson = q1.generate(movieId);
		
		//get the question String
		QuestionType qt = qtRepo.getRandomQuestionType();
		String displayQt = qt.getqTemplate();
		
		//replace the placeholder
		String title;
		try {
			title = questionJson.get("Title").toString();
		} catch (JSONException e) {
			e.printStackTrace();
			title = "";
		}
		displayQt = displayQt.replace("#MovieNameZ", title);
				
		return displayQt + "<br><br>" + questionJson;
	}

}
