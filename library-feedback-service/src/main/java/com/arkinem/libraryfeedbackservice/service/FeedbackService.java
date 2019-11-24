package com.arkinem.libraryfeedbackservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.arkinem.libraryfeedbackservice.dao.FeedbackDao;
import com.arkinem.libraryfeedbackservice.model.QuestionDto;
import com.arkinem.libraryfeedbackservice.model.Vote;

@Service
public class FeedbackService {
	
	private final FeedbackDao feedbackDao;

	@Autowired
	public FeedbackService(@Qualifier("fakeDao") FeedbackDao feedbackDao) {
		this.feedbackDao = feedbackDao;
	}
	
	public int insertQuestion(QuestionDto questionDto) {
		return feedbackDao.insertQuestion(questionDto);
	}
	
	public int insertVote(Vote vote) {
		return feedbackDao.insertVote(vote);
	}
	
	public List<QuestionDto> selectAllQuestions() {
		return feedbackDao.selectAllQuestions();
	}
}

