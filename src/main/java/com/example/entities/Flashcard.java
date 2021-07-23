package com.example.entities;

import java.sql.Timestamp;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "flashcard")
public class Flashcard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flashcard_id")
	private long id;
	@Column(name="createddate")
	private Timestamp createdDate;
	@Column(name="question")
	private String question;
	@Column(name="answer")
	private String answer; 
	
	@ManyToOne
	@JoinColumn(name = "flashcardset_id")
	@JsonIgnoreProperties({"flashcard"})
	private FlashcardSet flashcardSet;
	
	public Flashcard() {
		super();
	}
	
	public Flashcard(long id, Timestamp createdDate, String question, String answer, FlashcardSet flashcardSet) {
		super();
		this.id = id;
		this.createdDate = createdDate;
		this.question = question;
		this.answer = answer;
		this.flashcardSet = flashcardSet;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Timestamp getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Timestamp createdDate) {
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
	
	

	public FlashcardSet getFlashcardSet() {
		return flashcardSet;
	}

	public void setFlashcardSet(FlashcardSet flashcardSet) {
		this.flashcardSet = flashcardSet;
	}

	@Override
	public String toString() {
		return "Flashcard [id=" + id + ", createdDate=" + createdDate + ", question=" + question + ", answer=" + answer
				+ ", flashcardSet=" + flashcardSet + "]";
	}

	
}
