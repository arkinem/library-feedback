package com.arkinem.libraryfeedbackservice.api;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arkinem.libraryfeedbackservice.model.QuestionDto;
import com.arkinem.libraryfeedbackservice.model.Vote;
import com.arkinem.libraryfeedbackservice.service.FeedbackService;

@RequestMapping("api/v1")
@RestController
public class FeedbackController {
	
	private final FeedbackService feedbackService;
	
	@Autowired
	public FeedbackController(FeedbackService feedbackService) {
		this.feedbackService = feedbackService;
	}
	
	@PostMapping("question")
	public void insertQuestion(@Valid @NotNull @RequestBody QuestionDto questionDto) {
		feedbackService.insertQuestion(questionDto);
	}
	
	@GetMapping("question")
	public List<QuestionDto> selectAllQuestions() {
		return feedbackService.selectAllQuestions();
	}
	
	@PostMapping("vote")
	public void insertVote(@Valid @NotNull @RequestBody Vote vote) {
		feedbackService.insertVote(vote);
	}
}
