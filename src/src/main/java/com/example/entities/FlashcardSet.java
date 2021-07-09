package com.example.entities;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	private Calendar createdDate;
	@Column(name="lastmodifieddate")
	private Calendar lastModifiedDate;
	
	@OneToMany(mappedBy = "flashcardSet", fetch = FetchType.LAZY)
	private Set<Flashcard> flashcard = new HashSet<Flashcard>(); 
	
	
	@ManyToMany
	@JoinTable(name = "tag_flashcardset", // the junction table that contains the information connecting the two
	joinColumns = { @JoinColumn (name = "flashcardset_id")},
	inverseJoinColumns = { @JoinColumn (name = "tag_id")})	
	private Set<Tag> tags = new HashSet<Tag>();
	
	public FlashcardSet() {
		super();
	}
	
	public FlashcardSet(int id, String title, Calendar createdDate, Calendar lastModifiedDate, Set<Flashcard> flashcard,
			Set<Tag> tag) {
		super();
		this.id = id;
		this.title = title;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
		this.flashcard = flashcard;
		this.tags = tag;
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

	public Calendar getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Calendar createdDate) {
		this.createdDate = createdDate;
	}

	public Calendar getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Calendar lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Set<Flashcard> getMovies() {
		return flashcard;
	}

	public void setMovies(Set<Flashcard> movies) {
		this.flashcard = movies;
	}

	public Set<Tag> getActors() {
		return tags;
	}

	public void setActors(Set<Tag> actors) {
		this.tags = actors;
	}

	@Override
	public String toString() {
		return "FlashcardSet [id=" + id + ", title=" + title + ", createdDate=" + createdDate + ", lastModifiedDate="
				+ lastModifiedDate + ", flashcard=" + flashcard + ", tag=" + tags + "]";
	}
	
	
}
