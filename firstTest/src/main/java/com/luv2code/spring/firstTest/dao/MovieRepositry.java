package com.luv2code.spring.firstTest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.luv2code.spring.firstTest.entity.Movie;

public interface MovieRepositry extends JpaRepository<Movie, Integer> {

	public Movie findByTitle(String title);
}
