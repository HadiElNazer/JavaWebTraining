package com.luv2code.spring.firstTest.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.spring.firstTest.entity.ListMovie;
import com.luv2code.spring.firstTest.entity.Movie;
import com.luv2code.spring.firstTest.service.ListMovieService;

@RestController
@RequestMapping("/api/listmovie")
public class ListMovieController {

	private ListMovieService listMovieService;

	@Autowired
	public ListMovieController(ListMovieService l) {
		listMovieService = l;
	}

	@PostMapping
	public ListMovie addListMovie(@RequestBody ListMovie newListMovie) {
		listMovieService.save(newListMovie);
		return newListMovie;
	}

	@DeleteMapping("/{id}")
	public void deleteListMovie(@PathVariable int id) {
		listMovieService.deleteById(id);
	}

	@GetMapping("/addMovie/{id}")
	public void addMovieToList(@PathVariable int id, @RequestBody Movie movie) {
		listMovieService.addMovietoList(id, movie.getId());
	}

	@GetMapping("/removeMovie/{id}")
	public void removeMovieYoList(@PathVariable int id, @RequestBody Movie movie) {
		listMovieService.deleteMovieToList(id, movie.getId());
	}

	@GetMapping("/findAll")
	public List<ListMovie> findAll() {
		return listMovieService.findAll();
	}

	@GetMapping("/theMost")
	public ListMovie getTheMost() {
		return listMovieService.findTheMostMovie();
	}

	@GetMapping("/ordered")
	public List<ListMovie> getOrdered(HttpServletRequest request) {
		String filter = request.getParameter("filter");
		System.out.println(filter);
		return listMovieService.findAllOrdered(filter);

	}
}