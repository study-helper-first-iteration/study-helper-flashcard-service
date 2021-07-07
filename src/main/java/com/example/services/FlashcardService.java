package com.example.services;

import java.util.List;

import com.example.entities.Flashcard;

public interface FlashcardService {
	//CREATE
	public Flashcard createFlashcard(Flashcard a);
	//READ
	public Flashcard getFlashcardById(int id);
	public List<Flashcard> getAllFlashcards();
	//UPDATE
	public Flashcard updateFlashcard(Flashcard a);
	//DELETE
	public boolean deleteFlashcard(Flashcard a);
}
