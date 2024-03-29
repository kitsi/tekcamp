package com.teksystems.bootcamp.springboot.movierental.service;

import com.teksystems.bootcamp.springboot.movierental.model.Rating;
import com.teksystems.bootcamp.springboot.movierental.model.Review;
import com.teksystems.bootcamp.springboot.movierental.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Page<Rating> getRatings(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Rating> ratings = ratingRepository.findAll(pageable);
        return ratings;
    }

    public Optional<Rating> getRating(Long id) {
        return ratingRepository.findById(id);
    }

    public void deleteRating(Long id) {
        ratingRepository.deleteById(id);
    }

    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating updateRating(Long id, Rating ratingDetails) {
        Rating rating = ratingRepository.findById(id).get();
        rating.setNumStars(ratingDetails.getNumStars());
        rating.setDescription(ratingDetails.getDescription());
        return ratingRepository.save(rating);
    }
}
