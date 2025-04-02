package com.job.portals.RozgarBazar.repository;

import com.job.portals.RozgarBazar.entity.HiringWorker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HiringRepository extends JpaRepository<HiringWorker, Long> {
    boolean existsByJobIdAndWorkerId(Long jobId, Long workerId);
}
