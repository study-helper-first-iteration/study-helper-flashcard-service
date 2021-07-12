package com.example.entities;

import java.sql.Timestamp;
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

import org.springframework.context.annotation.Lazy;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


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
	private Timestamp createdDate;
	@Column(name="lastmodifieddate")
	private Timestamp lastModifiedDate;
	
	@Lazy
	@OneToMany(mappedBy = "flashcardSet", fetch = FetchType.LAZY)
	private Set<Flashcard> flashcard = new HashSet<Flashcard>(); 
	
	@Lazy
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tag_flashcardset", // the junction table that contains the information connecting the two
	joinColumns = { @JoinColumn (name = "flashcardset_id")},
	inverseJoinColumns = { @JoinColumn (name = "tag_id")})
	@JsonIgnoreProperties({"fs"})
	@JsonIgnore
	private Set<Tag> tags = new HashSet<Tag>();
	
	public FlashcardSet() {
		super();
	}
	
	public FlashcardSet(int id, String title, Timestamp createdDate, Timestamp lastModifiedDate, Set<Flashcard> flashcard,
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

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Timestamp getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Timestamp lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Set<Flashcard> getFlashcard() {
		return flashcard;
	}

	public void setFlashcard(Set<Flashcard> flashcard) {
		this.flashcard = flashcard;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "FlashcardSet [id=" + id + ", title=" + title + ", createdDate=" + createdDate + ", lastModifiedDate="
				+ lastModifiedDate + ", flashcard=" + flashcard +  ", tags=" + tags +"]";
	}

	
	
}
