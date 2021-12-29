package com.mongodbTest.MongoDB.repositry;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongodbTest.MongoDB.model.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

	public Movie findByTitle(String title);
}
