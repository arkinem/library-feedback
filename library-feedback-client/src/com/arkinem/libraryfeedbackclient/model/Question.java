package com.arkinem.libraryfeedbackclient.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;

public class Question {
	
	private final UUID id;
	private final String body;
	private final List<Answer> answers; 
	
	private final boolean isDeleted;
	
	public Question(UUID id, String body, List<Answer> answers, boolean isDeleted) {
		this.id = id;
		this.body = body;
		this.answers = answers;
		this.isDeleted = isDeleted;
	}
	
	public UUID getId( ) {
		return id;
	}
	
	public String getBody() {
		return body;
	}
	
	public List<Answer> getAnswers() {
		return answers;
	}
	
	public boolean getIsDeleted() {
		return isDeleted;
	}
	
	public static List<Question> parseQuestionsFromJSON(String data) {
		List <Question> result = new ArrayList<>();
	 	JSONArray questions = new JSONArray(data);
	 	
	 	for (int i = 0; i < questions.length(); i++) {
	 		JSONObject question = questions.getJSONObject(i);
	 		JSONArray answers = question.getJSONArray("answers");
	 		List <Answer> questionAnswers = new ArrayList<>();
	 		
	 		for(int j = 0; j < answers.length(); j++) {
	 			JSONObject answer = questions.getJSONObject(j);
	 			questionAnswers.add(new Answer(UUID.fromString(answer.getString("id")), answer.getString("body")));
	 		}
	 		
	 		result.add(new Question(
	 				UUID.fromString(question.getString("id")),
	 				question.getString("body"),
	 				questionAnswers,
	 				question.getBoolean("isDeleted")
	 				)); 
	 		
	 	}
	 	
		return result;
	}
}
