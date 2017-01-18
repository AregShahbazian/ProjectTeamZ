package com.teamz.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Configuration;

import com.teamz.domain.QuestionType;
import com.teamz.repository.QuestionTypeRepository;

@Configuration
public class QuestionTypeConfiguration {
	
	@Inject
	private QuestionTypeRepository questionTypeRepository;
	
	@Inject
	public void buildQuestionTypeRepo(){
		String[] questionTypes = {"year" , "director", "actors"};
		String[] questionTemplates = {"In which year was the movie #MovieNameZ released?", 
										"Who directed #MovieNameZ?",
										"Which actors played in #MovieNameZ"};
		if (questionTypes.length == questionTemplates.length){
			//build the database of question types
			for (int i = 0; i < questionTypes.length; i++){
				QuestionType qt = new QuestionType();
				qt.setqType(questionTypes[i]);
				qt.setqTemplate(questionTemplates[i]);
				
				questionTypeRepository.save(qt);
			}
		}
	}
}
