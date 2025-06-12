package com.job.portals.RozgarBazar.controller;


import com.job.portals.RozgarBazar.dto.Shortlisted;
import com.job.portals.RozgarBazar.dto.ShortlistedDto;
import com.job.portals.RozgarBazar.entity.Employee;
import com.job.portals.RozgarBazar.entity.Worker;
import com.job.portals.RozgarBazar.model.EmployeeProfile;
import com.job.portals.RozgarBazar.model.EmployeeProfileDto;
import com.job.portals.RozgarBazar.model.WorkerProfile;
import com.job.portals.RozgarBazar.model.WorkerProfileDto;
import com.job.portals.RozgarBazar.service.EmployeeService;
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

    private final WorkerService workerService;

    @Autowired
    public EmployeeController(WorkerService workerService) {

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
