package com.teamz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question {
	//contains individual shown questions within a quiz
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotNull
	@JsonIgnore
	@ManyToOne //if one object contains another, you cannot specify it as column. 
	//To map objects to each other, use cardinality annotations.
	private QuestionType qType; 
	
	@NotNull
	@JsonIgnore
	@ManyToOne
	private Movie qMovie;
	
	@Column
	private boolean correctlyAnswered;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public QuestionType getqType() {
		return qType;
	}
	public void setqType(QuestionType qType) {
		this.qType = qType;
	}
	public Movie getqMovie() {
		return qMovie;
	}
	public void setqMovie(Movie qMovie) {
		this.qMovie = qMovie;
	}
	
	public boolean getCorrectlyAnswered() {
		return this.correctlyAnswered;
	}
	
	public void setCorrectlyAnswered(boolean correct) {
		this.correctlyAnswered = correct;
	}
	
}
