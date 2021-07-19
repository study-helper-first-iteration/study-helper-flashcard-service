package com.example.app;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Flashcard;
import com.example.entities.FlashcardSet;
import com.example.services.FlashcardService;
import com.example.services.FlashcardSetService;


@SpringBootTest
@ContextConfiguration(classes=com.example.demo.FlashcardsApplication.class)
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FlashcardServiceImplTest {

	@Autowired
	FlashcardService fs;
	@Autowired
	FlashcardSetService fss;
	
	@Test
	@Order(1)
	void createFlashcard() {
		Flashcard fc = new Flashcard();
		FlashcardSet fcs = fss.getFlashcardSetById(1);
		
		fc.setQuestion("Where is my pen?");
		fc.setAnswer("On the far side of the moon!");
		fc.setFlashcardSet(fcs);
		fs.createFlashcard(fc);
		
		Flashcard fc2 = fs.getFlashcardById(fc.getId());
		Assertions.assertSame(fc.getAnswer(),fc2.getAnswer());
	}
	
	@Test
	@Order(2)
	void getAllFlashcards() {
		List<Flashcard> fcSet = (ArrayList<Flashcard>) fs.getAllFlashcards();
	}

}
