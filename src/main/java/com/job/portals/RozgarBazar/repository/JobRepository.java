package com.job.portals.RozgarBazar.repository;

import com.job.portals.RozgarBazar.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {

}