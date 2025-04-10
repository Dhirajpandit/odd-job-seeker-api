package com.job.portals.RozgarBazar.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.job.portals.RozgarBazar.entity.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    @Query("SELECT j FROM Job j WHERE " +
            "(:location IS NULL OR j.location = :location) AND " +
            "(:skills IS NULL OR j.description LIKE %:skills%) AND " +
            "(:jobType IS NULL OR j.title LIKE %:jobType%)")
    List<Job> findJobs(@Param("location") Optional<String> location,
            @Param("skills") Optional<String> skills,
            @Param("jobType") Optional<String> jobType);
}
