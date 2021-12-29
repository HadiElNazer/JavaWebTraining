package com.mongodbTest.MongoDB.service;

import java.util.List;

import com.mongodbTest.MongoDB.model.ListMovie;

public interface ListMovieServiceInterface {
	public ListMovie insertOneList(ListMovie listMovie);

	public void deleteOneList(String id);

	public ListMovie findOneList(String id);

	public List<ListMovie> getAllList();

	public void addMovieAtList(String idListMovie, String idMovie);

	public void removeMovieAtList(String idListMovie, String idMovie);

	public ListMovie getTheMost();

	public List<ListMovie> getAllOrdered(String filter);
}
