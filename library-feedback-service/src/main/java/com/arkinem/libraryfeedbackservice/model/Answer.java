package com.arkinem.libraryfeedbackservice.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Answer {
	private final UUID id;
	@NotBlank
	private final String body;
	
	public Answer(@JsonProperty("id") UUID id,
				  @JsonProperty("body") String body) {
		this.id = id;
		this.body = body;
	}
	
	public UUID getId( ) {
		return id;
	}
	
	public String getBody() {
		return body;
	}
}