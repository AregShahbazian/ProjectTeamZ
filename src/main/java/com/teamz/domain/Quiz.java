package com.teamz.domain;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Quiz {
	//contains data about one quiz session 
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToMany(fetch = FetchType.EAGER) //automatically queries the questions with the Quiz
	private List<Question> questions = new ArrayList<>();
	
	@Column
	private Integer counter;
	
	@Column
	private ZonedDateTime startedAt;
	
	@Column
	private ZonedDateTime endedAt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
		counter = questions.size();
	}

	public Integer getCounter() {
		return counter;
	}

	public void setCounter(Integer counter) {
		this.counter = counter;
	}

	public ZonedDateTime getStartedAt() {
		return startedAt;
	}

	public void setStartedAt(ZonedDateTime startedAt) {
		this.startedAt = startedAt;
	}

	public ZonedDateTime getEndedAt() {
		return endedAt;
	}

	public void setEndedAt(ZonedDateTime endedAt) {
		this.endedAt = endedAt;
	}

	public void add(Question newQuestion) {
		questions.add(newQuestion);
	}
	
	
	
}
