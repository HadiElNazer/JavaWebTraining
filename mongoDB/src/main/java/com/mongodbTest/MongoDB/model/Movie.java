package com.mongodbTest.MongoDB.model;

import java.time.LocalDate;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movie")
public class Movie {
	@Id
	private String id;
	private String title;
	private Genre genre;
	private String directorName;
	private LocalDate releaseDate;

	public Movie() {

	}

	public Movie(String title, Genre genre, String directorName, LocalDate releaseDate) {
		this.title = title;
		this.genre = genre;
		this.directorName = directorName;
		this.releaseDate = releaseDate;
	}

	public Movie(String id, String title, Genre genre, String directorName, LocalDate releaseDate) {
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.directorName = directorName;
		this.releaseDate = releaseDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "ListMovie [id=" + id + ", title=" + title + ", releaseDate=" + releaseDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(directorName, genre, id, releaseDate, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(directorName, other.directorName) && genre == other.genre && Objects.equals(id, other.id)
				&& Objects.equals(releaseDate, other.releaseDate) && Objects.equals(title, other.title);
	}

}
