package com.mongodbTest.MongoDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodbTest.MongoDB.model.Movie;
import com.mongodbTest.MongoDB.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	MovieService movieSerice;

	@PostMapping
	public Movie addMovie(@RequestBody Movie movie) {
		return movieSerice.insertOne(movie);
	}

	@PutMapping("/{id}")
	public void updateMovie(@PathVariable String id, @RequestBody Movie movie) {
		movieSerice.updateOneMovie(id, movie);
	}
	
	@DeleteMapping("/{id}")
	public void deleteMovie(@PathVariable String id) {
		movieSerice.deleteOneMovie(id);
	}
	
	@GetMapping("/getAll")
	public List<Movie> getAllMovies(){
		return movieSerice.getAllMovies();
	}
}
