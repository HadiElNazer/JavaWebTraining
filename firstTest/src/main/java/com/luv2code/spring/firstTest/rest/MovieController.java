package com.luv2code.spring.firstTest.rest;


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

import com.luv2code.spring.firstTest.entity.Movie;
import com.luv2code.spring.firstTest.service.MovieService;

@RestController
@RequestMapping("/api/movie")
public class MovieController {

	MovieService movieservice;

	@Autowired
	public MovieController(MovieService m) {
		movieservice = m;
	}

	@GetMapping("/findAll")
	public List<Movie> getAllMovie() {
		List<Movie> list = movieservice.findAll();
		return list;
	}

	@DeleteMapping("/{id}")
	public void deleteMovie(@PathVariable int id) {
		movieservice.deleteById(id);
	}

	@PostMapping
	public Movie addMovie(@RequestBody Movie movie) {
		movieservice.save(movie);
		return movie;

	}

	@PutMapping("/{id}")
	public void updateMovie(@PathVariable int id, @RequestBody Movie movie) {
		movieservice.updateMovie(id, movie);
	}

}
