package com.arkinem.libraryfeedbackservice.model;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class QuestionDto {
	
	private final UUID id;
	@NotBlank
	private final String body;
	@NotBlank
	private final List<Answer> answers; 
	
	private final boolean isDeleted;
	
	public QuestionDto(UUID id, String body, List<Answer> answers, boolean isDeleted) {
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
	
	public List<Answer> getAnswers() {
		return answers;
	}
	
	public boolean getIsDeleted() {
		return isDeleted;
	}
}