package com.example.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "flashcardset")
public class FlashcardSet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flashcardset_id")
	private int id;
	@Column(name="title")
	private String title;
	@Column(name="createddate")
	private long createdDate;
	@Column(name="lastmodifieddate")
	private long lastModifiedDate;
	@OneToMany(mappedBy = "flashcardset", fetch = FetchType.LAZY)
	private Set<Flashcard> flashcard = new HashSet<Flashcard>(); 
	@ManyToMany(mappedBy ="flashcardset")
	private Set<Tag> tag = new HashSet<Tag>();
	
	public FlashcardSet(int id, String title, long createdDate, long lastModifiedDate, Set<Flashcard> flashcard,
			Set<Tag> tag) {
		super();
		this.id = id;
		this.title = title;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.flashcard = flashcard;
		this.tag = tag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(long createdDate) {
		this.createdDate = createdDate;
	}

	public long getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(long lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Set<Flashcard> getMovies() {
		return flashcard;
	}

	public void setMovies(Set<Flashcard> movies) {
		this.flashcard = movies;
	}

	public Set<Tag> getActors() {
		return tag;
	}

	public void setActors(Set<Tag> actors) {
		this.tag = actors;
	}

	@Override
	public String toString() {
		return "FlashcardSet [id=" + id + ", title=" + title + ", createdDate=" + createdDate + ", lastModifiedDate="
				+ lastModifiedDate + ", flashcard=" + flashcard + ", tag=" + tag + "]";
	}
	
	
}
