package com.example.royalflixbackend.services;


import com.example.royalflixbackend.MoviesEntities.Movies;
import com.example.royalflixbackend.repo.mongoRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    mongoRepo repo;

    public List<Movies> getAll(){
       return repo.findAll();

    }

    public Optional<Movies> getById(ObjectId id){
        return repo.findById(id);
    }

    public Optional<Movies> getByimdbId(String id){
        return repo.findMoviesByimdbId(id);
    }

    public Movies createMovies(Movies movie){
        return repo.save(movie);
    }
}
