package com.luv2code.spring.firstTest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.luv2code.spring.firstTest.dao.MovieRepositry;
import com.luv2code.spring.firstTest.entity.Movie;
import com.luv2code.spring.firstTest.exception.MovieAlreadyException;
import com.luv2code.spring.firstTest.exception.MovieNotFoundException;
import com.luv2code.spring.firstTest.exception.MovieRelationException;

@Service
public class MovieServiceImpl implements MovieService {

	private MovieRepositry movieRepositry;

	@Autowired
	public MovieServiceImpl(MovieRepositry m) {
		movieRepositry = m;

	}

	@Override
	@Transactional
	public List<Movie> findAll() {
		return movieRepositry.findAll();

	}

	@Override
	@Transactional
	public Movie findById(int theId) {
		Movie m = null;
		Optional<Movie> result = movieRepositry.findById(theId);
		if (result.isPresent()) {
			m = result.get();
		}
		return m;
	}

	@Override
	@Transactional
	public void save(Movie movie) {
		Movie exist = this.findByTitle(movie.getTitle());
		if (exist != null) {
			throw new MovieAlreadyException("already exist");
		}
		movieRepositry.save(movie);

	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		Movie exist = this.findById(theId);
		if (exist == null) {
			throw new MovieNotFoundException("Not Exist This id");
		}
		if (exist.getListId() != null) {
			throw new MovieRelationException("in relation");
		}
		movieRepositry.deleteById(theId);

	}

	@Override
	@Transactional
	public Movie findByTitle(String title) {
		return movieRepositry.findByTitle(title);
	}

	@Override
	@Transactional
	public void updateMovie(int id, Movie m) {
		Movie movie = this.findById(id);
		if (movie == null) {
			throw new MovieNotFoundException("Not Exist This id");
		}
		movie.setGenre(m.getGenre());
		movie.setReleaseDate(m.getReleaseDate());
		movie.setTitle(m.getTitle());
		movie.setDirectorName(m.getDirectorName());
		movieRepositry.save(movie);

	}

}
