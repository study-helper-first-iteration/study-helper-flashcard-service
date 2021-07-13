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

import com.example.entities.Tag;
import com.example.services.TagService;

@RestController
@CrossOrigin("*")
public class TagController {
	
	@Autowired
	TagService ts;
	
	@ResponseBody
	@PostMapping(value = "/tag")
	public Tag createTag(@RequestBody Tag t) {
		return ts.createTag(t);
	}
	
	
	@ResponseBody
	@GetMapping(value = "/tags")
	public List<Tag> getAllTags(){
		return ts.getTags();
	}
	
	@ResponseBody
	@GetMapping(value = "/tags/{id}")
	public Tag getTagById(@PathVariable int id) {
		try {
			return ts.getTagById(id);
		}catch(NoSuchElementException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find tag"); 
		}
	}
	
	@ResponseBody
	@PutMapping(value = "/tags")
	public Tag updateTag(@RequestBody Tag t) {
		return ts.updateTag(t);
	}
	
	@ResponseBody
	@DeleteMapping(value = "/tags")
	public void deleteTag(@RequestBody Tag t) {
		boolean result = ts.deleteTag(t);
		if(result == false) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Did not delete");
		}
	}
}
