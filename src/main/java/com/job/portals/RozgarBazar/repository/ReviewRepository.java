package com.job.portals.RozgarBazar.repository;

import com.job.portals.RozgarBazar.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
