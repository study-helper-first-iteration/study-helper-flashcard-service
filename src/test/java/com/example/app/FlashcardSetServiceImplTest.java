package com.example.app;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.entities.Flashcard;
import com.example.entities.FlashcardSet;
import com.example.entities.Tag;
import com.example.services.FlashcardSetService;
import com.example.services.TagService;


@SpringBootTest
@ContextConfiguration(classes=com.example.demo.FlashcardsApplication.class)
@Transactional
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FlashcardSetServiceImplTest {

	@Autowired
	FlashcardSetService fss;
	@Autowired
	TagService ts;
	
	@Test
	void createFlashcardSet() {
		
		Tag t = ts.getTagById(1);
		Set<Tag> tagSet = new HashSet<Tag>(); 
		tagSet.add(t);
		
		FlashcardSet fs = new FlashcardSet();
		fs.setTitle("Dorky Test");
		fs.setTags(tagSet);
		fss.createFlashcardSet(fs);
		
		FlashcardSet fs2 = fss.getFlashcardSetById(fs.getId());
		Assertions.assertSame(fs,fs2);
	}
	
	@Test
	void getAllFlashcardSets() {
		List<FlashcardSet> f =  fss.getAllFlashcardSets();
		Assertions.assertNotNull(f);
	}
	
	@Test
	void getFlashcardSetById() {
		FlashcardSet fs = fss.getFlashcardSetById(1);
		Assertions.assertEquals(1,fs.getId());
	}

}
