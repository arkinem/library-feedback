package com.arkinem.libraryfeedbackservice.dao;

import java.util.List;
import java.util.UUID;

import com.arkinem.libraryfeedbackservice.model.QuestionDto;
import com.arkinem.libraryfeedbackservice.model.Vote;

public interface FeedbackDao {

	int insertQuestion(UUID id, QuestionDto questionDto);
	
	default int insertQuestion(QuestionDto questionDto) {
		UUID id = UUID.randomUUID();
		return insertQuestion(id, questionDto);
	}
	
	int insertVote(UUID id, Vote vote);
	
	default int insertVote(Vote vote) {
		UUID id = UUID.randomUUID();
		return insertVote(id, vote);
	}
	
	List<QuestionDto> selectAllQuestions();
	
}
