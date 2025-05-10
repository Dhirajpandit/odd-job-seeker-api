package com.job.portals.RozgarBazar.controller;


import com.job.portals.RozgarBazar.dto.Shortlisted;
import com.job.portals.RozgarBazar.dto.ShortlistedDto;
import com.job.portals.RozgarBazar.entity.Employee;
import com.job.portals.RozgarBazar.entity.Job;
import com.job.portals.RozgarBazar.entity.Worker;
import com.job.portals.RozgarBazar.model.EmployeeProfile;
import com.job.portals.RozgarBazar.model.EmployeeProfileDto;
import com.job.portals.RozgarBazar.model.WorkerProfile;
import com.job.portals.RozgarBazar.model.WorkerProfileDto;
import com.job.portals.RozgarBazar.service.EmployeeService;
import com.job.portals.RozgarBazar.service.JobService;
import com.job.portals.RozgarBazar.service.WorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/jobs")
public class EmployeeController {

//    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

//    @Autowired
//    private EmployeeService employeeService;
//
//    @PostMapping("/post")
//    public ResponseEntity<Employee> createProfile(@RequestBody EmployeeProfileDto empProfile) {
//        Employee employee = employeeService.createProfile(empProfile);
//        return ResponseEntity.ok(employee);
//    }

//    @Autowired
//    private EmployeeService employerService;
//
//    @PostMapping("/shortlist")
//    public ShortlistedDto shortlistWorker(@RequestBody Shortlisted request) {
//        return employerService.shortlistWorker(request);
//    }
//    private final WorkerService jobService;
//
//    public EmployeeController(WorkerService jobService) {
//        this.jobService = jobService;
//    }
//
//    @PostMapping("/post")
//    public Job postJob(@RequestBody Job job) {
//        return jobService.postJob(job);
//    }
    private final JobService jobService;

    @PostMapping
    public ResponseEntity<Job> createJob(@RequestBody Job job) {
        Job createdJob = jobService.createJob(job);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdJob);
    }

    @GetMapping("/{jobId}")
    public ResponseEntity<Job> getJob(@PathVariable String jobId) {
        return jobService.getJobById(jobId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/employer/{employerId}")
    public List<Job> getJobsByEmployer(@PathVariable String employerId) {
        return jobService.getJobsByEmployer(employerId);
    }

    @PostMapping("/apply")
    public ResponseEntity<String> applyToJob(
            @RequestParam String jobId,
            @RequestParam String workerId) {

        jobService.applyToJob(jobId, workerId);
        return ResponseEntity.ok("Applied successfully");
    }

    @DeleteMapping("/{jobId}")
    public ResponseEntity<Void> deleteJob(@PathVariable String jobId) {
        jobService.deleteJob(jobId);
        return ResponseEntity.noContent().build();
    }

    private final WorkerService workerService;

    @Autowired
    public EmployeeController(JobService jobService, WorkerService workerService) {
        this.jobService = jobService;
        this.workerService = workerService;
    }

    @GetMapping("/suggestedWorkers")
    public ResponseEntity<List<Worker>> getSuggestedWorkers(
            @RequestParam(required = false) String jobId,
            @RequestParam(required = false) String employerId,
            @RequestParam(required = false) Set<String> skills,
            @RequestParam(required = false) String location) {

        List<Worker> workers = workerService.getSuggestedWorkers(jobId, employerId, skills, location);
        return ResponseEntity.ok(workers);
    }

    private WorkerProfileDto convertToWorkerResponse(Worker worker) {
        return new WorkerProfileDto(
                worker.getWorkerId(),
                worker.getName(),
                worker.getRating(),
                worker.getSkills()
        );
    }

//    @PostMapping("/post")
//    public Employee createEmployee(@RequestBody Employee employee) {
//        return employeeService.createProfile(employee);
//    }




//
//    @PostMapping("/post")
//    public Employee createEmployee(@RequestBody Employee employee) {
//        return employeeService.saveEmployee(employee);
//    }

//    @GetMapping
//    public ResponseEntity<EmployeeProfile> getEmployeeProfile() {
//        EmployeeProfile EmpProfile = service.getEmployeeProfile();
//        return ResponseEntity.ok(EmpProfile);
//    }
}
