package com.mongodbTest.MongoDB.repositry;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongodbTest.MongoDB.model.ListMovie;

@Repository
public interface ListMovieRepository extends MongoRepository<ListMovie, String> {

	public ListMovie findByName(String name);

	@Aggregation(pipeline = { "{$sort:{arrayOfMovies:-1}}", "{$limit:1}" })
	public ListMovie findTheMost();

}
