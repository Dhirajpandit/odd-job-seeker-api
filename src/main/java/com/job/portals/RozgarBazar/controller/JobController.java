//package com.job.portals.RozgarBazar.controller;
//
//import com.job.portals.RozgarBazar.entity.Job;
//import com.job.portals.RozgarBazar.service.JobService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/jobs")
//public class JobController {
//
//    private final JobService jobService;
//
//    @Autowired
//    public JobController(JobService jobService) {
//        this.jobService = jobService;
//    }
//
//    @PostMapping
//    public ResponseEntity<Job> createJob(@RequestBody Job job) {
//        Job createdJob = jobService.createJob(job);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdJob);
//    }
//
//    @GetMapping("/{jobId}")
//    public ResponseEntity<Job> getJob(@PathVariable String jobId) {
//        return jobService.getJobById(jobId)
//                .map(ResponseEntity::ok)
//                .orElse(ResponseEntity.notFound().build());
//    }
//
//    @GetMapping
//    public List<Job> getAllJobs() {
//        return jobService.getAllJobs();
//    }
//    @PostMapping("/apply")
//    public ResponseEntity<String> applyToJob(
//            @RequestParam String jobId,
//            @RequestParam String workerId) {
//
//        jobService.applyToJob(jobId, workerId);
//        return ResponseEntity.ok("Applied successfully");
//    }
//
//    @GetMapping("/employer/{employerId}")
//    public List<Job> getJobsByEmployer(@PathVariable String employerId) {
//        return jobService.getJobsByEmployer(employerId);
//    }
//
//    @DeleteMapping("/{jobId}")
//    public ResponseEntity<Void> deleteJob(@PathVariable String jobId) {
//        jobService.deleteJob(jobId);
//        return ResponseEntity.noContent().build();
//    }
//}
