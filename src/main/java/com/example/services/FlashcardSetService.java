package com.example.services;

import java.util.List;

import com.example.entities.FlashcardSet;

public interface FlashcardSetService {
	//CREATE
	public FlashcardSet createFlashcardSet(FlashcardSet a);
	//READ
	public FlashcardSet getFlashcardSetById(long id);
	public FlashcardSet  getFlashcardSetByTitle(String title);
	public List<FlashcardSet> getAllFlashcardSets();
	//UPDATE
	public FlashcardSet updateFlashcardSet(FlashcardSet a);
	//DELETE
	public boolean deleteFlashcardSet(FlashcardSet a);
}
