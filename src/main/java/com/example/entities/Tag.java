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
import javax.persistence.Table;

import org.springframework.context.annotation.Lazy;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tag")
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tag_id")
	private int id;
	@Column(name="title")
	private String title;
	
	@Lazy
	@ManyToMany(mappedBy ="tags", fetch=FetchType.LAZY)
	@JsonIgnoreProperties({"tags"})
	private Set<FlashcardSet> fs = new HashSet<FlashcardSet>();
	
	public Tag() {
		super();
	}
	
	public Tag(int id, String title, Set<FlashcardSet> flashcardSet) {
		super();
		this.id = id;
		this.title = title;
		this.fs = flashcardSet;
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

	public Set<FlashcardSet> getFlashcardSet() {
		return fs;
	}

	public void setFlashcardSet(Set<FlashcardSet> flashcardSet) {
		this.fs = flashcardSet;
	}

	@Override
	public String toString() {
		return "Tag [id=" + id + ", title=" + title + ", flashcardSet=" + fs + "]";
	}
	
	
	
}
