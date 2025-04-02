package com.job.portals.RozgarBazar.repository;

import com.job.portals.RozgarBazar.controller.WorkerController;
import com.job.portals.RozgarBazar.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
    @Query("SELECT w FROM Worker w " +
            "WHERE (:id IS NULL OR w.id = :id) " +
            "AND (:skills IS NULL OR w.skills LIKE %:skills%) " +
            "AND (:location IS NULL OR w.location = :location)")
    List<Worker> findSuggestedWorkers(
            @Param("id") Long id,
            @Param("skills") String skills,
            @Param("location") String location
    );


}