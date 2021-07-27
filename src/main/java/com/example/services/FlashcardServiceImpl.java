package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.entities.Flashcard;
import com.example.repositories.*;

@Component
@Service
public class FlashcardServiceImpl implements FlashcardService{
	
	@Autowired
	FlashcardRepository fr;

	@Override
	public Flashcard createFlashcard(Flashcard a) {
		return fr.save(a);
	}

	@Override
	public Flashcard getFlashcardById(long id) {
		return fr.findById(id).orElse(null);
	}

	@Override
	public List<Flashcard> getAllFlashcards() {
		return fr.findAll();
	}

	@Override
	public Flashcard updateFlashcard(Flashcard a) {
		return fr.save(a);
	}

	@Override
	public boolean deleteFlashcard(Flashcard a) {
		fr.delete(a);
		return true;
	}
	
	
}
