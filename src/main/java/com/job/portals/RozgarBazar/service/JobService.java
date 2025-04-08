package com.job.portals.RozgarBazar.service;

import com.job.portals.RozgarBazar.entity.Job;
import com.job.portals.RozgarBazar.repository.JobRepository;

import java.util.List;
import java.util.Optional;

public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public Optional<Job> getJobById(String jobId) {
        return jobRepository.findById(jobId);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public List<Job> getJobsByEmployer(String employerId) {
        return jobRepository.findByEmployerId(employerId);
    }

    public void deleteJob(String jobId) {
        jobRepository.deleteById(Long.valueOf(jobId));
    }
}
