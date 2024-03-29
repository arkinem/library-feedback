package com.arkinem.libraryfeedbackservice.model;

import java.util.List;
import java.util.UUID;

import javax.validation.constraints.NotBlank;

public class Question {
	
	private final UUID id;
	@NotBlank
	private final String body;
	@NotBlank
	private final List<UUID> answerIds; 
	
	private final boolean isDeleted;
	
	public Question(UUID id, String body, List<UUID> answerIds, boolean isDeleted) {
		this.id = id;
		this.body = body;
		this.answerIds = answerIds;
		this.isDeleted = isDeleted;
	}
	
	public UUID getId( ) {
		return id;
	}
	
	public String getBody() {
		return body;
	}
	
	public List<UUID> getAnswerIds() {
		return answerIds;
	}
	
	public boolean getIsDeleted() {
		return isDeleted;
	}
}