package com.example.royalflixbackend.services;

import com.example.royalflixbackend.MoviesEntities.Movies;
import com.example.royalflixbackend.MoviesEntities.Reviews;
import com.example.royalflixbackend.repo.ReviewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    ReviewRepo repo;
    @Autowired
    private MongoTemplate mongoTemplate;
    public Reviews createReview(String reviewBody,String ImdbId){
        Reviews reviews=repo.insert(new Reviews(reviewBody));

        mongoTemplate.update(Movies.class)
                .matching(Criteria.where("imdbId").is(ImdbId))
                .apply(new Update().push("reviewIds").value(reviews))
                .first();
        return reviews;


    }
}
