package com.qaproject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Question {
	
	@Id
	@Column(name = "q_id")
	private int id;
	
	@Column(name = "q_name")
	private String name;
	
	
	@Enumerated(EnumType.STRING)
	private Level difficulty;
	
	@OneToOne(mappedBy = "questions")
	private QuestionDetail detail;
	
	@OneToMany(mappedBy = "questions", fetch= FetchType.EAGER,
			orphanRemoval=true, cascade= CascadeType.ALL)
	private List<Answer> answer = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Level getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Level difficulty) {
		this.difficulty = difficulty;
	}

	public QuestionDetail getDetail() {
		return detail;
	}

	public void setDetail(QuestionDetail detail) {
		this.detail = detail;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

}
