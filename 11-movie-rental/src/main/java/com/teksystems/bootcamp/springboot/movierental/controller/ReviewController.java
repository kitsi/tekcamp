package com.teksystems.bootcamp.springboot.movierental.controller;

import com.teksystems.bootcamp.springboot.movierental.model.Review;
import com.teksystems.bootcamp.springboot.movierental.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/")
    public Page<Review> getReviews(
            @RequestParam(value = "pageNum", defaultValue = "0", required = false) int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ) {
        return reviewService.getReviews(pageNum, pageSize);
    }

    @GetMapping("/{id}")
    public Optional<Review> getReview(@PathVariable(value = "id") Long reviewId) {
        return reviewService.getReview(reviewId);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable(value = "id") Long reviewId) {
        reviewService.deleteReview(reviewId);
    }

    @PostMapping("/")
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable(value = "id") Long reviewId, @RequestBody Review reviewDetails) {
        return reviewService.updateReview(reviewId, reviewDetails);
    }
}
