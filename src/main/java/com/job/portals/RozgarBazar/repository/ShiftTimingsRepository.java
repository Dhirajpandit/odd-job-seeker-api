package com.job.portals.RozgarBazar.repository;

import com.job.portals.RozgarBazar.entity.ShiftTimings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftTimingsRepository extends JpaRepository<ShiftTimings, Long> {
}