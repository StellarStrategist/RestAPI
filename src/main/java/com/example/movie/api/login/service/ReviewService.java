package com.example.movie.api.login.service;

import com.example.movie.api.login.entity.Movie;
import com.example.movie.api.login.entity.Review;
import com.example.movie.api.login.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
public class ReviewService {
    private ReviewRepository repository;
    private MongoTemplate mongoTemplate;
    @Autowired
    ReviewService(ReviewRepository repository,MongoTemplate mongoTemplate) {
        this.mongoTemplate=mongoTemplate;
        this.repository=repository;
    }
    public Review createReview(String reviewBody, String imdbId) {
        Review review=repository.insert(new Review(reviewBody, LocalDateTime.now(),LocalDateTime.now()));
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviews").value(review))
                .first();
        return review;
    }
}
