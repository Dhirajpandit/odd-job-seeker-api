package com.job.portals.RozgarBazar.controller;

import com.job.portals.RozgarBazar.entity.Review;
import com.job.portals.RozgarBazar.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/review")
@CrossOrigin(origins = "*")
@Slf4j
public class ReviewController {
    private static final Logger log = LoggerFactory.getLogger(ReviewController.class);
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Review> getAllReviews() {
        List<Review> allReviews = reviewService.getAllReviews();
        log.info(allReviews.toArray().toString());
        return allReviews;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable("id") Long id) {
        Optional<Review> review = reviewService.getReviewById(id);
        return review.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewService.addReview(review);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable Long id, @RequestBody Review updatedReview) {
        Review updated = reviewService.updateReview(id, updatedReview);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
