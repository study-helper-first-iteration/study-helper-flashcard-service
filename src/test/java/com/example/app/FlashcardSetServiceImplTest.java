package com.example.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.FlashcardSet;
import com.example.services.FlashcardSetService;


@SpringBootTest
@ContextConfiguration(classes=com.example.demo.FlashcardsApplication.class)
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FlashcardSetServiceImplTest {

	@Autowired
	FlashcardSetService fss;
	
	@Test
	void getFlashcardSetById() {
		FlashcardSet fs = fss.getFlashcardSetById(1);
		Assertions.assertSame(fs.getTitle(), "Dumb Questions");
	}

}
