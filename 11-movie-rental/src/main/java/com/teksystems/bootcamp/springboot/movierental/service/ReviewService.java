package com.teksystems.bootcamp.springboot.movierental.service;

import com.teksystems.bootcamp.springboot.movierental.model.Review;
import com.teksystems.bootcamp.springboot.movierental.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public Page<Review> getReviews(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Review> reviews = reviewRepository.findAll(pageable);
        return reviews;
    }

    public Optional<Review> getReview(Long id) {
        return reviewRepository.findById(id);
    }

    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }

    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(Long id, Review reviewDetails) {
        Review review = reviewRepository.findById(id).get();
        review.setCustomer(reviewDetails.getCustomer());
        review.setFilm(reviewDetails.getFilm());
        review.setRating(reviewDetails.getRating());
        review = reviewRepository.findById(id).get();
        return reviewRepository.save(review);
    }
}
