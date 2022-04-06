package com.teksystems.bootcamp.springboot.movierental.service;

import com.teksystems.bootcamp.springboot.movierental.model.Review;
import com.teksystems.bootcamp.springboot.movierental.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReview(Long id) {
        return reviewRepository.findById(id);
    }

//    add getReviewFilm

//    add getReviewCustomer

    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(Long reviewId, Review reviewDetails) {
        Review review = reviewRepository.findById(reviewId).get();
        review.setCustomer(reviewDetails.getCustomer());
        review.setFilm(reviewDetails.getFilm());

        return reviewRepository.save(review);
    }
}
