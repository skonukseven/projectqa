package com.qaproject;

import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class QuestionDetail {
	
	@Id
	private int id;
	private String Standard;
	
	@OneToOne
	@JoinColumn(name= "question_id")
	private Question questions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStandard() {
		return Standard;
	}

	public void setStandard(String standard) {
		Standard = standard;
	}

	public Question getQuestions() {
		return questions;
	}

	public void setQuestions(Question questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "QuestionDetail [id=" + id + ", Standard=" + Standard + ", questions=" + questions + "]";
	}

}
