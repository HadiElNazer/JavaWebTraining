package com.mongodbTest.MongoDB.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodbTest.MongoDB.exception.MovieAlreadyException;
import com.mongodbTest.MongoDB.exception.MovieNotFoundException;
import com.mongodbTest.MongoDB.model.Movie;
import com.mongodbTest.MongoDB.repositry.MovieRepository;

@Service
public class MovieService implements MovieServiceInterface {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public Movie insertOne(Movie movie) {
		Movie movieExist = movieRepository.findByTitle(movie.getTitle());
		if (movieExist != null) {
			throw new MovieAlreadyException("alreadyExist");
		}
		Movie saved = movieRepository.insert(movie);
		return saved;
	}

	@Override
	public Movie findMovieById(String id) {
		Movie m = null;
		Optional<Movie> result = movieRepository.findById(id);
		if (result.isPresent()) {
			m = result.get();
		}
		return m;
	}

	@Override
	public void updateOneMovie(String id, Movie movieUpdate) {
		Movie movie = this.findMovieById(id);
		if (movie == null) {
			throw new MovieNotFoundException("not found Movieid");
		}
		movie.setGenre(movieUpdate.getGenre());
		movie.setDirectorName(movieUpdate.getDirectorName());
		movie.setReleaseDate(movieUpdate.getReleaseDate());
		movie.setTitle(movieUpdate.getTitle());
		movieRepository.save(movie);
	}

	@Override
	public void deleteOneMovie(String id) {
		Movie movie = this.findMovieById(id);
		if (movie == null) {
			throw new MovieNotFoundException("not found Movieid");
		}
		movieRepository.deleteById(id);
	}

	@Override
	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}
}
