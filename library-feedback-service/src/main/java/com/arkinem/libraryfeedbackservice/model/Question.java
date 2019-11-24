package com.arkinem.libraryfeedbackservice.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Question {
	
	private final UUID id;
	@NotBlank
	private final String body;
	@NotBlank
	private final Answer[] answers; 
	
	private final boolean isDeleted;
	
	public Question(@JsonProperty("id") UUID id,
				  @JsonProperty("body") String body,
				  @JsonProperty("answers") Answer[] answers,
				  @JsonProperty("isDeleted") boolean isDeleted) {
		this.id = id;
		this.body = body;
		this.answers = answers;
		this.isDeleted = isDeleted;
	}
	
	public UUID getId( ) {
		return id;
	}
	
	public String getBody() {
		return body;
	}
	
	public Answer[] getAnswers() {
		return answers;
	}
	
	public boolean getIsDeleted() {
		return isDeleted;
	}
}