package com.example.royalflixbackend.repo;

import com.example.royalflixbackend.MoviesEntities.Movies;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface mongoRepo extends MongoRepository<Movies, ObjectId>  {

    Optional<Movies>findMoviesByimdbId(String imdbId);
}
