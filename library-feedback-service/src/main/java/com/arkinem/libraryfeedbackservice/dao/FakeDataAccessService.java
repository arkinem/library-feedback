package com.arkinem.libraryfeedbackservice.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.arkinem.libraryfeedbackservice.model.Question;
import com.arkinem.libraryfeedbackservice.model.QuestionDto;
import com.arkinem.libraryfeedbackservice.model.Answer;
import com.arkinem.libraryfeedbackservice.model.Vote;

@Repository("fakeDao")
public class FakeDataAccessService implements FeedbackDao {
	
	private static List<Question> questions =  new ArrayList<>(); 
	
	private static List<Answer> answers =  new ArrayList<>(); 
	
	private static List<Vote> votes =  new ArrayList<>();
	
	
	@Override
	public List<QuestionDto> selectAllQuestions() {
		List<QuestionDto> result = new ArrayList<>();
		List<Question> activeQuestions = questions.stream()
				.filter(question -> question.getIsDeleted() == false).collect(Collectors.toList());
		
		for (Question question : activeQuestions) {
			List<Answer> questionAnswers = new ArrayList<>();
			
			for(UUID id : question.getAnswerIds()) {
				Answer answer = selectAnswerById(id).orElse(null);
				questionAnswers.add(new Answer(answer.getId(), answer.getBody()));
			}
			
			result.add(new QuestionDto(question.getId(),question.getBody(), questionAnswers, question.getIsDeleted()));
		}
		
		return result;
	}
	
	private Optional<Question> selectQuestionById(UUID id) {
		return questions.stream()
				.filter(question -> question.getId().equals(id))
				.findFirst();
	}
	
	@Override
	public int insertQuestion(UUID id, QuestionDto questionDto) {
		List<UUID> answerIds = new ArrayList<>();
		
		for (Answer answer : questionDto.getAnswers()) {
			UUID createdId = insertAnswer(answer);
			answerIds.add(createdId);
		}
		
		questions.add(new Question(id, 
								   questionDto.getBody(), 
								   answerIds, 
								   questionDto.getIsDeleted()
								   ));
		return 1;
	}

	private boolean validateQuestionById(UUID id) {
		Question question = selectQuestionById(id).orElse(null);
		
		if(!question.equals(null) && !question.getIsDeleted())
			return true;
		
		return false;
	}
	
	@Override
	public int insertVote(UUID id, Vote vote) {
		boolean validQuestionId = validateQuestionById(vote.getQuestionId());
		boolean validAnswerId = !selectAnswerById(vote.getAnswerId()).equals(null);
		
		if(validQuestionId && validAnswerId) {
			votes.add(new Vote(id, vote.getTimestamp(), vote.getQuestionId(), vote.getAnswerId()));
			return 1;
		}
		
		return 0;
	}
	
	private Optional<Answer> selectAnswerById(UUID id) {
		return answers.stream()
				.filter(answer -> answer.getId().equals(id))
				.findFirst();
	}

	public UUID insertAnswer(UUID id, Answer answer) {
		answers.add(new Answer(id,answer.getBody()));
		return id;
	} 
	
	public UUID insertAnswer(Answer answer) {
		UUID id = UUID.randomUUID();
		return insertAnswer(id, answer);
	}
	
}
