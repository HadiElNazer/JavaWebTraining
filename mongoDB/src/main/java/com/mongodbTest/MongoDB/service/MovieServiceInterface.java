package com.mongodbTest.MongoDB.service;

import java.util.List;

import com.mongodbTest.MongoDB.model.Movie;

public interface MovieServiceInterface {
	public Movie insertOne(Movie movie);

	public Movie findMovieById(String id);

	public void deleteOneMovie(String id);

	public List<Movie> getAllMovies();

	public void updateOneMovie(String id, Movie movieUpdate);
}
