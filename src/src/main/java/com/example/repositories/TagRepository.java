package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.entities.*;

@Component
@Repository
public interface TagRepository extends JpaRepository<Tag, Integer>{
	Tag findByTitle(String title);
}
