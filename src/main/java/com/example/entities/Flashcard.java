package com.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "flashcard")
public class Flashcard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flashcard_id")
	private int id;
	@Column(name="createddate")
	private long createdDate;
	@Column(name="question")
	private String question;
	@Column(name="answer")
	private String answer; 
	@JoinColumn(name = "flashcard_id")
	private FlashcardSet flashcardSet;
	
	
	public Flashcard(int id, long createdDate, String question, String answer) {
		super();
		this.id = id;
		this.createdDate = createdDate;
		this.question = question;
		this.answer = answer;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public long getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(long createdDate) {
		this.createdDate = createdDate;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Flashcard [id=" + id + ", createdDate=" + createdDate + ", question=" + question + ", answer=" + answer
				+ "]";
	}
	
	
	
}
