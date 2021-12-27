package com.luv2code.spring.firstTest.service;

import java.util.List;

import com.luv2code.spring.firstTest.entity.ListMovie;

public interface ListMovieService {

	public void save(ListMovie listMovie);

	public void deleteById(int theId);

	public List<ListMovie> findAll();

	public void addMovietoList(int theId, int idMovie);

	public void deleteMovieToList(int theId, int idMovie);

	public ListMovie findTheMostMovie();

	public List<ListMovie> findAllOrdered(String filter);

	public ListMovie findById(int theId);

	public ListMovie findByName(String name);
}
