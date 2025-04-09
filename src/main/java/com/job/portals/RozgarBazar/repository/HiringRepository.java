package com.job.portals.RozgarBazar.repository;

import com.job.portals.RozgarBazar.entity.HiringWorker;
import com.job.portals.RozgarBazar.entity.Job;
import com.job.portals.RozgarBazar.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HiringRepository extends JpaRepository<HiringWorker, Long> {

//    @Query("SELECT CASE WHEN COUNT(h) > 0 THEN true ELSE false END " +
//            "FROM HiringWorker h " +
//            "WHERE h.jobId = :jobId AND h.workerId = :workerId")
//    boolean existsByJobIdAndWorkerId(@Param("jobId") Long jobId,
//                                     @Param("workerId") Long workerId);
}
