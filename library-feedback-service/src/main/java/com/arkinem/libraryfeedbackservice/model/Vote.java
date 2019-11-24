package com.arkinem.libraryfeedbackservice.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Vote {
	private final UUID id;
	@NotBlank
	private final Long timestamp;
	@NotBlank
	private final UUID questionId; 
	
	private final UUID answerId;
	
	public Vote(@JsonProperty("id") UUID id,
				  @JsonProperty("timestamp") Long timestamp,
				  @JsonProperty("questionId") UUID questionId,
				  @JsonProperty("answerId") UUID answerId) {
		this.id = id;
		this.timestamp = timestamp;
		this.questionId = questionId;
		this.answerId = answerId;
	}
	
	public UUID getId( ) {
		return id;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
	public UUID getQuestionId() {
		return questionId;
	}
	
	public UUID getAnswerId() {
		return answerId;
	}
}
