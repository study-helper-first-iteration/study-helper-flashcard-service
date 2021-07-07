package com.example.services;

import java.util.List;

import com.example.entities.Tag;

public interface TagService {
	//CREATE
	public Tag createTag(Tag a);
	//READ
	public Tag getTagById(int id);
	public Tag  getTagByTitle(String title);
	public List<Tag> getTags();
	//UPDATE
	public Tag updateTag(Tag a);
	//DELETE
	public boolean deleteTag(Tag a);
}
