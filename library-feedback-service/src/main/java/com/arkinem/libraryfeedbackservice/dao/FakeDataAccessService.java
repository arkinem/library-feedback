package com.arkinem.libraryfeedbackservice.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.arkinem.libraryfeedbackservice.model.Question;
import com.arkinem.libraryfeedbackservice.model.Answer;
import com.arkinem.libraryfeedbackservice.model.Vote;

@Repository("fakeDao")
public class FakeDataAccessService implements FeedbackDao {
	
	private static List<Question> questions =  new ArrayList<>(); 
	private static List<Answer> answers =  new ArrayList<>(); 
	private static List<Vote> votes =  new ArrayList<>();
	
	@Override
	public int insertQuestion(UUID id, Question question) {
		List<UUID> results = new ArrayList<>();
		for (Answer answer : question.getAnswers()) {
			UUID createdId = insertAnswer(answer);
			results.add(createdId);
		}
		
		//questions.add(new Question(id, ));
		
		//
		// no i tu mam problem bo przeciez uzytkownik wysle mi obiekt question bez id,
		// ja musze go edytowac, nadac id, dodac do listy "answers" a potem jeszcze caly ten obiekt dodac
		// do questions. bede miec liste questions i kazde pytanie bedzie mialo kilka obiektow question
		// a do tego jeszcze druga liste ze zduplikowanymi questions. troche bez sensu nie? 
		// jak to lepiej ogarnac? 
		//
		
		return 0;
	}
	
	@Override
	public int insertVote(UUID id, Vote vote) {
		// TODO Auto-generated method stub
		return 0;
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
