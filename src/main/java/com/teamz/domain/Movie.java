package com.teamz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

//annotations define this as entity in the database
@Entity
public class Movie {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Column(unique = true, nullable = false)
	private String apiId;
	
	public String getApiId() {
		return apiId;
	}
	public void setApiId(String apiId) {
		this.apiId = apiId;
	}
	public Long getMovieId() {
		return id;
	}
	public void setMovieId(Long movieId) {
		this.id = movieId;
	}
	
}