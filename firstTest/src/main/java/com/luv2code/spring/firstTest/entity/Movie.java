package com.luv2code.spring.firstTest.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "movie")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "genre")
	@Enumerated(EnumType.STRING)
	private Genre genre;

	@Column(name = "releaseDate")
	private LocalDate releaseDate;

	@Column(name = "directorName")
	private String directorName;

	@JsonBackReference
	@ManyToOne
	private ListMovie listId;

	public Movie() {
	}

	public Movie(String title, Genre genre, LocalDate releaseDate, String directorName) {
		this.title = title;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.directorName = directorName;
	}

	public Movie(int id, String title, Genre genre, LocalDate releaseDate, String directorName) {
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.directorName = directorName;
	}

	public ListMovie getListId() {
		return listId;
	}

	public void setListId(ListMovie listId) {
		this.listId = listId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

}
