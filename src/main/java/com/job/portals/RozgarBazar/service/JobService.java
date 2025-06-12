package com.job.portals.RozgarBazar.service;

import com.job.portals.RozgarBazar.entity.Job;
import com.job.portals.RozgarBazar.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public Optional<Job> getJobById(String jobId) {
        return jobRepository.findById(Long.valueOf(jobId));
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    public List<Job> getJobsByEmployer(String employerId) {
        return null;
    }

    public void deleteJob(String jobId) {
        jobRepository.deleteById(Long.valueOf(jobId));
    }


    public void applyToJob(String jobId, String workerId) {
      /*  Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found"));

        // Example: maybe maintain a list of workerIds inside Job entity
        job.getAppliedWorkerIds().add(workerId);

        jobRepository.save(job);*/
    }
}




//    @Autowired
//    public JobService(JobRepository jobRepository) {
//        this.jobRepository = jobRepository;
//    }
//@Service
//public class JobService {
//
//    private final JobRepository jobRepository;
//
//
//}
