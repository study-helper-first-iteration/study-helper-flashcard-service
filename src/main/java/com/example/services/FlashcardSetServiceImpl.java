package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.entities.FlashcardSet;
import com.example.repositories.FlashcardSetRepository;

@Component
@Service
public class FlashcardSetServiceImpl implements FlashcardSetService{
	
	@Autowired
	FlashcardSetRepository fsr;
	
	@Override
	public FlashcardSet createFlashcardSet(FlashcardSet a) {
		return fsr.save(a);
	}

	@Override
	public FlashcardSet getFlashcardSetById(int id) {
		return fsr.findById(id).orElse(null);
	}

	@Override
	public FlashcardSet getFlashcardSetByTitle(String title) {
		return fsr.findByTitle(title);
	}

	@Override
	public List<FlashcardSet> getAllFlashcardSets() {
		return fsr.findAll();
	}

	@Override
	public FlashcardSet updateFlashcardSet(FlashcardSet a) {
		return fsr.save(a);
	}

	@Override
	public boolean deleteFlashcardSet(FlashcardSet a) {
		fsr.delete(a);
		return true;
	}

}
