package com.arkinem.libraryfeedbackservice.dao;

import java.util.UUID;

import com.arkinem.libraryfeedbackservice.model.Answer;

public interface AnswerDao {

	int insertAnswer(UUID id, Answer answer);
	
	default int insertAnswer(Answer answer) {
		UUID id = UUID.randomUUID();
		return insertAnswer(id, answer);
	}
	
}