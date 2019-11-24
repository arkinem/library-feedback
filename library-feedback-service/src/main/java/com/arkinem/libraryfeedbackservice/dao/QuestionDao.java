package com.arkinem.libraryfeedbackservice.dao;

import java.util.UUID;

import com.arkinem.libraryfeedbackservice.model.Question;

public interface QuestionDao {

	int insertQuestion(UUID id, Question question);
	
	default int insertQuestion(Question question) {
		UUID id = UUID.randomUUID();
		return insertQuestion(id, question);
	}
	
}
