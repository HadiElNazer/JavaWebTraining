package com.luv2code.spring.firstTest.entity;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIdentityReference;

@Entity
@Table(name = "listMovie")
public class ListMovie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "date")
	private LocalDate date;

	@JsonIdentityReference
	@OneToMany
	// @JoinColumn(name="listId",referencedColumnName = "id")
	private Set<Movie> movies;

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public ListMovie() {
	}

	public ListMovie(String name, LocalDate date) {
		this.name = name;
		this.date = date;
	}

	@Override
	public String toString() {
		return "ListMovie [id=" + id + ", name=" + name + ", date=" + date + ", movies=" + movies + "]";
	}

}
