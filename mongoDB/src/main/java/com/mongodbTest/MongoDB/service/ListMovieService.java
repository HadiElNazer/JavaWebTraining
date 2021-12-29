package com.mongodbTest.MongoDB.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mongodbTest.MongoDB.exception.ListMovieAlreadyException;
import com.mongodbTest.MongoDB.exception.ListMovieNotFoundException;
import com.mongodbTest.MongoDB.exception.MovieNotFoundException;
import com.mongodbTest.MongoDB.model.ListMovie;
import com.mongodbTest.MongoDB.model.Movie;
import com.mongodbTest.MongoDB.repositry.ListMovieRepository;

@Service
public class ListMovieService implements ListMovieServiceInterface {
	@Autowired
	private ListMovieRepository listMovieRepository;
	@Autowired
	private MovieService movieService;

	@Override
	public ListMovie insertOneList(ListMovie listMovie) {
		ListMovie listexist = listMovieRepository.findByName(listMovie.getName());
		if (listexist != null) {
			throw new ListMovieAlreadyException("already Exist");
		}
		listMovie.setCreationDate(LocalDate.now());
		return listMovieRepository.insert(listMovie);
	}

	@Override
	public void deleteOneList(String id) {
		ListMovie listExist = this.findOneList(id);
		if (listExist == null) {
			throw new ListMovieNotFoundException("not Found this id");
		}
		listMovieRepository.deleteById(id);
	}

	@Override
	public ListMovie findOneList(String id) {
		ListMovie list = null;
		Optional<ListMovie> res = listMovieRepository.findById(id);
		if (res.isPresent()) {
			list = res.get();
		}
		return list;
	}

	@Override
	public List<ListMovie> getAllList() {
		return listMovieRepository.findAll();
	}

	@Override
	public void addMovieAtList(String idListMovie, String idMovie) {

		ListMovie listMovie = this.findOneList(idListMovie);
		Movie movie = movieService.findMovieById(idMovie);
		if (listMovie == null) {
			throw new ListMovieNotFoundException("not found thislist");
		}
		if (movie == null) {
			throw new MovieNotFoundException("not found this movie");
		}
		List<Movie> arrayOfMovie = listMovie.getArrayOfMovies();
		arrayOfMovie.add(movie);
		listMovie.setArrayOfMovies(arrayOfMovie);
		listMovieRepository.save(listMovie);

	}

	@Override
	public void removeMovieAtList(String idListMovie, String idMovie) {
		ListMovie listMovie = this.findOneList(idListMovie);
		Movie movie = movieService.findMovieById(idMovie);
		if (listMovie == null) {
			throw new ListMovieNotFoundException("not found thislist");
		}
		if (movie == null) {
			throw new MovieNotFoundException("not found this movie");
		}
		List<Movie> arrayOfMovie = listMovie.getArrayOfMovies();
		arrayOfMovie.remove(movie);
		listMovie.setArrayOfMovies(arrayOfMovie);
		listMovieRepository.save(listMovie);
	}

	@Override
	public List<ListMovie> getAllOrdered(String filter) {
		return listMovieRepository.findAll(Sort.by(filter).ascending());

	}

	@Override
	public ListMovie getTheMost() {
		// List<ListMovie> list =
		// listMovieRepository.findAll(Sort.by("arrayOfMovies").descending());
		// return list.get(0);
		return listMovieRepository.findTheMost();
	}
}
