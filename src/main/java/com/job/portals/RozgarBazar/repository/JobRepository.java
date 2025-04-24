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
    Map<String, Job> jobs = new ConcurrentHashMap<>();

    public default Job save(Job job) {
        if (job.getJobId() == null) {
            job.setJobId((UUID.randomUUID().toString()));
        }
        jobs.put(String.valueOf(job.getJobId()), job);
        return job;
    }

    public default Optional<Job> findById(String jobId) {
        return Optional.ofNullable(jobs.get(jobId));
    }

    public default List<Job> findByEmployerId(String employerId) {
        return jobs.values().stream()
                .filter(job -> job.getEmployerId().equals(employerId))
                .collect(Collectors.toList());
    }

    public default void deleteById(String jobId) {
        jobs.remove(jobId);
    }
//    boolean existsById(Long id);
}