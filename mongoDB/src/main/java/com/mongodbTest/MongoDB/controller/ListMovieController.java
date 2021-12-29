package com.mongodbTest.MongoDB.controller;

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

import com.mongodbTest.MongoDB.model.ListMovie;
import com.mongodbTest.MongoDB.model.Movie;
import com.mongodbTest.MongoDB.service.ListMovieService;

@RestController
@RequestMapping("/listMovie")
public class ListMovieController {

	@Autowired
	private ListMovieService listMovieService;

	@PostMapping
	public ListMovie create(@RequestBody ListMovie listMovie) {
		return listMovieService.insertOneList(listMovie);
	}

	@DeleteMapping("/{id}")
	public void deleteList(@PathVariable String id) {
		listMovieService.deleteOneList(id);
	}

	@GetMapping("/getAll")
	public List<ListMovie> getAllListmovie() {
		return listMovieService.getAllList();
	}

	@GetMapping("/addMovieAtList/{idList}")
	public void addMovieAtList(@PathVariable String idList, @RequestBody Movie movie) {
		listMovieService.addMovieAtList(idList, movie.getId());
	}

	@GetMapping("/removeMovieAtList/{idList}")
	public void removeMovieAtList(@PathVariable String idList, @RequestBody Movie movie) {
		listMovieService.removeMovieAtList(idList, movie.getId());
	}

	@GetMapping("/ordered")
	public List<ListMovie> getAllOrdered(HttpServletRequest request) {
		String filter = request.getParameter("filter");
		return listMovieService.getAllOrdered(filter);
	}

	@GetMapping("/theMost")
	public String gettheMost() {
		return listMovieService.getTheMost().getName();

	}
}
