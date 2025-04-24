package com.job.portals.RozgarBazar.service;

import com.job.portals.RozgarBazar.entity.Review;
import com.job.portals.RozgarBazar.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    public Review updateReview(Long id, Review updatedReview) {
        Optional<Review> existingReview = reviewRepository.findById(id);
        if (existingReview.isPresent()) {
            Review review = existingReview.get();
            review.setJobPortalName(updatedReview.getJobPortalName());
            review.setReviewer(updatedReview.getReviewer());
            review.setRating(updatedReview.getRating());
            review.setComments(updatedReview.getComments());
            return reviewRepository.save(review);
        } else {
            throw new RuntimeException("Review not found for id: " + id);
        }
    }

    public void deleteReview(Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new RuntimeException("Review not found for id: " + id);
        }
        reviewRepository.deleteById(id);
    }
}