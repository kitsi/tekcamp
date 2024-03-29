package com.teksystems.bootcamp.springboot.movierental.controller;

import com.teksystems.bootcamp.springboot.movierental.model.Rating;
import com.teksystems.bootcamp.springboot.movierental.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/")
    public Page<Rating> getRatings(
            @RequestParam(value = "pageNum", defaultValue = "0", required = false) int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ) {
        return ratingService.getRatings(pageNum, pageSize);
    }

    @GetMapping("/{id}")
    public Optional<Rating> getRating(@PathVariable(value = "id") Long ratingId) {
        return ratingService.getRating(ratingId);
    }

    @DeleteMapping("/{id}")
    public void deleteRating(@PathVariable(value = "id") Long id) {
        ratingService.deleteRating(id);
    }

    @PostMapping("/")
    public Rating createRating(@RequestBody Rating rating) {
        return ratingService.createRating(rating);
    }

    @PutMapping("/{id}")
    public Rating updateReview(@PathVariable(value = "id") Long id, @RequestBody Rating ratingDetails) {
        return ratingService.updateRating(id, ratingDetails);
    }
}
