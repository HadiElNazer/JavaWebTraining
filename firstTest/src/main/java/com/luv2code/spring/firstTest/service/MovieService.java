package com.luv2code.spring.firstTest.service;

import java.util.List;

import com.luv2code.spring.firstTest.entity.Movie;

public interface MovieService {

	public List<Movie> findAll();

	public Movie findById(int theId);

	public void save(Movie movie);

	public void deleteById(int theId);

	public Movie findByTitle(String title);

	public void updateMovie(int id, Movie m);
}
