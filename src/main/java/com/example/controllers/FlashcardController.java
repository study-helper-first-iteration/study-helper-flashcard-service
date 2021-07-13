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

import com.example.entities.Flashcard;
import com.example.services.FlashcardService;


@RestController
@CrossOrigin("*")
public class FlashcardController {
	
	@Autowired
	FlashcardService fs;
	
	@ResponseBody
	@PostMapping(value = "/flashcard")
	public Flashcard createFlashcard(@RequestBody Flashcard f) {
		return fs.createFlashcard(f);
	}
	
	
	@ResponseBody
	@GetMapping(value = "/flashcards")
	public List<Flashcard> getAllFlashcards(){
		return fs.getAllFlashcards();
	}
	
	@ResponseBody
	@GetMapping(value = "/flashcards/{id}")
	public Flashcard getFlashcardById(@PathVariable int id) {
		try {
			return fs.getFlashcardById(id);
		}catch(NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find flashcard"); 
		}
	}
	
	@ResponseBody
	@PutMapping(value = "/flashcards")
	public Flashcard updateFlashcard(@RequestBody Flashcard f) {
		return fs.updateFlashcard(f);
	}
	
	@ResponseBody
	@DeleteMapping(value = "/flashcards")
	public void deleteFlashcard(@RequestBody Flashcard f) {
		boolean result = fs.deleteFlashcard(f);
		if(result == false) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Did not delete");
		}
	}
	
}
