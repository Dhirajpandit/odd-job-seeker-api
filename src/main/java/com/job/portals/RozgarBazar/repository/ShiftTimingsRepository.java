package com.job.portals.RozgarBazar.repository;

import com.job.portals.RozgarBazar.model.ShiftTimings;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftTimingsRepository extends JpaRepository<ShiftTimings, Long> {
}