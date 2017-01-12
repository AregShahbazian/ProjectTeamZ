package com.teamz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class QuestionType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	@Column(unique = true, nullable = false)
	private String qType;
	
	@NotNull
	@Column(length = 1000)
	private String qTemplate;
	
	public String getqTemplate() {
		return qTemplate;
	}

	public void setqTemplate(String qTemplate) {
		this.qTemplate = qTemplate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getqType() {
		return qType;
	}

	public void setqType(String qType) {
		this.qType = qType;
	}


}
