package com.mongodbTest.MongoDB.model;

import java.time.LocalDate;
import java.util.List;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "listMovie")
public class ListMovie {
	@Id
	private String id;

	private String name;

	private LocalDate creationDate;

	@DocumentReference
	private List<Movie> arrayOfMovies ;

	public ListMovie() {

	}

	public ListMovie(String name, LocalDate creationDate, List<Movie> arrayOfMovies) {
		this.name = name;
		this.creationDate = creationDate;
		this.arrayOfMovies = arrayOfMovies;
	}

	public ListMovie(String id, String name, LocalDate creationDate, List<Movie> arrayOfMovies) {
		this.id = id;
		this.name = name;
		this.creationDate = creationDate;
		this.arrayOfMovies = arrayOfMovies;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public List<Movie> getArrayOfMovies() {
		return arrayOfMovies;
	}

	public void setArrayOfMovies(List<Movie> arrayOfMovies) {
		this.arrayOfMovies = arrayOfMovies;
	}
	
	@Override
	public String toString() {
		return "ListMovie [id=" + id + ", name=" + name + ", creationDate=" + creationDate + ", arrayOfMovies=" + arrayOfMovies + "]";
	}

}
