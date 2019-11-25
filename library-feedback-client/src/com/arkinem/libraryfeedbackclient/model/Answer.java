package com.arkinem.libraryfeedbackclient.model;

import java.util.UUID;


public class Answer {
	
	private UUID id;
	
	private final String body;
	
	public Answer(UUID id, String body) {
		this.id = id;
		this.body = body;
	}
	
	public UUID getId() {
		return id;
	}
	
	
	public String getBody() {
		return body;
	}
}