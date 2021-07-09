package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.entities.Tag;
import com.example.repositories.TagRepository;

@Component
@Service
public class TagServiceImpl implements TagService{

	@Autowired
	TagRepository tr;
	
	@Override
	public Tag createTag(Tag a) {
		return tr.save(a);
	}

	@Override
	public Tag getTagById(int id) {
		return tr.findById(id).orElse(null);
	}

	@Override
	public Tag getTagByTitle(String title) {
		return tr.findByTitle(title);
	}

	@Override
	public List<Tag> getTags() {
		return tr.findAll();
	}

	@Override
	public Tag updateTag(Tag a) {
		return tr.save(a);
	}

	@Override
	public boolean deleteTag(Tag a) {
		tr.delete(a);
		return true;
	}

}
