package com.job.portals.RozgarBazar.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    
    @GetMapping
    public ResponseEntity<List<Job>> getJobs(@RequestParam Optional<String> location,
                                             @RequestParam Optional<String> skills,
                                             @RequestParam Optional<String> jobType) {
        return ResponseEntity.ok(jobService.getJobs(location, skills, jobType));
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<Job> getJobById(@PathVariable Long jobId) {
        return ResponseEntity.ok(jobService.getJobById(jobId));
    }

    
    @PostMapping("/apply")
    public ResponseEntity<String> applyForJob(@RequestParam Long jobId, @RequestParam Long workerId) {
        return ResponseEntity.ok(jobService.applyForJob(jobId, workerId));
    }

    
    @PostMapping("/instant")
    public ResponseEntity<String> instantAcceptJob(@RequestBody InstantJobRequest request) {
        return ResponseEntity.ok(jobService.instantAcceptJob(request));
    }
}
