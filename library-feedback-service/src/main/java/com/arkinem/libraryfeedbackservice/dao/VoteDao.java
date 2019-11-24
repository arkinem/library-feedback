package com.arkinem.libraryfeedbackservice.dao;

import java.util.UUID;

import com.arkinem.libraryfeedbackservice.model.Vote;

public interface VoteDao {

	int insertVote(UUID id, Vote vote);
	
	default int insertVote(Vote vote) {
		UUID id = UUID.randomUUID();
		return insertVote(id, vote);
	}
	
}

