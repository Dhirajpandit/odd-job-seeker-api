package com.job.portals.RozgarBazar.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.job.portals.RozgarBazar.dto.JobDto;
import com.job.portals.RozgarBazar.entity.Job;
import com.job.portals.RozgarBazar.repository.JobRepository;

@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<JobDto> getJobs(Optional<String> location, Optional<String> skills, Optional<String> jobType) {
        return jobRepository.findJobs(location, skills, jobType)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public JobDto getJobById(Long jobId) {
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found with ID: " + jobId));
        return convertToDto(job);
    }

    private JobDto convertToDto(Job job) {
        return new JobDto(
                job.getJobId(),
                job.getTitle(),
                job.getDescription(),
                job.getLocation(),
                job.getPayRate(),
                job.getShiftTimings()
        );
    }
}
