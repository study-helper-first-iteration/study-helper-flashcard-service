package com.example.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.entities.FlashcardSet;
import com.example.services.FlashcardSetService;

@RestController
@CrossOrigin("*")
public class FlashcardSetController {

	@Autowired
	FlashcardSetService fss;

	@ResponseBody
	@PostMapping(value = "/flashcardSet")
	public FlashcardSet createFlashcardSet(@RequestBody FlashcardSet fs) {
		return fss.createFlashcardSet(fs);
	}

	@ResponseBody
	@GetMapping(value = "/flashcardSets")
	public List<FlashcardSet> getAllFlashcardSets() {
		return fss.getAllFlashcardSets();
	}

	@ResponseBody
	@GetMapping(value = "/flashcardSets/{id}")
	public FlashcardSet getFlashcardSetById(@PathVariable int id) {
		try {
			return fss.getFlashcardSetById(id);
		} catch (NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find flashcard set");
		}
	}

	@ResponseBody
	@PutMapping(value = "/flashcardSets")
	public FlashcardSet updateFlashcardSet(@RequestBody FlashcardSet fs) {
		return fss.updateFlashcardSet(fs);
	}

	@ResponseBody
	@DeleteMapping(value = "/flashcardSets")
	public void deleteFlashcardSet(@RequestBody FlashcardSet fs) {
		boolean result = fss.deleteFlashcardSet(fs);
		if (result == false) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Did not delete");
		}
	}
}
