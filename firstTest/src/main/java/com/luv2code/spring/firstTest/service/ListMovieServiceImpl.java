package com.luv2code.spring.firstTest.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.spring.firstTest.dao.ListMovieRepositry;
import com.luv2code.spring.firstTest.dao.MovieRepositry;
import com.luv2code.spring.firstTest.entity.ListMovie;
import com.luv2code.spring.firstTest.entity.Movie;
import com.luv2code.spring.firstTest.exception.ListMovieAlreadyException;
import com.luv2code.spring.firstTest.exception.ListMovieNotFoundException;
import com.luv2code.spring.firstTest.exception.MovieNotFoundException;

@Service
public class ListMovieServiceImpl implements ListMovieService {

	private ListMovieRepositry listMovieRepositry;
	private MovieRepositry movierepositry;

	@Autowired
	public ListMovieServiceImpl(ListMovieRepositry l, MovieRepositry m) {
		listMovieRepositry = l;
		movierepositry = m;
	}

	@Override
	@Transactional
	public void save(ListMovie listMovie) {
		ListMovie l = this.findByName(listMovie.getName());
		if (l != null) {
			throw new ListMovieAlreadyException("already exist this name");
		}
		listMovie.setDate(LocalDate.now());
		listMovieRepositry.save(listMovie);

	}

	@Override
	@Transactional
	public ListMovie findById(int theId) {
		ListMovie m = null;
		Optional<ListMovie> result = listMovieRepositry.findById(theId);
		if (result.isPresent()) {
			m = result.get();
		}
		return m;
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		ListMovie l = this.findById(theId);
		if (l == null) {
			throw new ListMovieNotFoundException("Not Found ID");
		}
		listMovieRepositry.deleteById(theId);

	}

	@Override
	@Transactional
	public void addMovietoList(int theId, int idMovie) {
		Movie existmovie = null;
		ListMovie existList = null;
		Optional<Movie> resultMovie = movierepositry.findById(idMovie);
		if (resultMovie.isPresent()) {
			existmovie = resultMovie.get();
			Optional<ListMovie> resultListMovie = listMovieRepositry.findById(theId);
			if (resultListMovie.isPresent()) {
				existList = resultListMovie.get();
				existmovie.setListId(existList);
				movierepositry.save(existmovie);
				existList.getMovies().add(existmovie);
				listMovieRepositry.save(existList);
			} else {
				throw new ListMovieNotFoundException("not found listmovie id");
			}
		} else {
			throw new MovieNotFoundException("not found movie id");
		}

	}

	@Override
	@Transactional
	public List<ListMovie> findAll() {
		return listMovieRepositry.findAll();
	}

	@Override
	@Transactional
	public void deleteMovieToList(int theId, int idMovie) {
		Movie existmovie = null;
		ListMovie existList = null;
		Optional<Movie> resultMovie = movierepositry.findById(idMovie);
		if (resultMovie.isPresent()) {
			existmovie = resultMovie.get();
			Optional<ListMovie> resultListMovie = listMovieRepositry.findById(theId);
			if (resultListMovie.isPresent()) {
				existList = resultListMovie.get();
				existmovie.setListId(null);
				movierepositry.save(existmovie);
				existList.getMovies().remove(existmovie);
				listMovieRepositry.save(existList);
			} else {
				throw new ListMovieNotFoundException("not found listmovie id");
			}
		} else {
			throw new MovieNotFoundException("not found movie id");
		}

	}

	@Override
	@Transactional
	public ListMovie findTheMostMovie() {
		List<Object[]> aray = listMovieRepositry.getTheMost();
		ListMovie theMost = (ListMovie) aray.get(0)[0];
		return theMost;
	}

	@Override
	@Transactional
	public List<ListMovie> findAllOrdered(String filter) {
		return listMovieRepositry.findAll(Sort.by(filter).ascending());
	}

	@Override
	@Transactional
	public ListMovie findByName(String name) {
		return listMovieRepositry.findByName(name);
	}

}
