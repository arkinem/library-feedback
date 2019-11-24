package com.arkinem.libraryfeedbackservice.dao;

import java.util.UUID;

import com.arkinem.libraryfeedbackservice.model.Question;
import com.arkinem.libraryfeedbackservice.model.Vote;

public interface FeedbackDao {

	int insertQuestion(UUID id, Question question);
	
	default int insertQuestion(Question question) {
		UUID id = UUID.randomUUID();
		return insertQuestion(id, question);
	}
	
	int insertVote(UUID id, Vote vote);
		
	
	default int insertVote(Vote vote) {
		UUID id = UUID.randomUUID();
		return insertVote(id, vote);
	}
}
