package com.job.portals.RozgarBazar.controller;
import com.job.portals.RozgarBazar.dto.Shortlisted;
import com.job.portals.RozgarBazar.entity.Worker;
import com.job.portals.RozgarBazar.model.*;
import com.job.portals.RozgarBazar.service.WorkerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/worker")
public class WorkerController {

//    @Autowired
//    private WorkerService jobService;
//
//    @GetMapping("/suggestedWorkers")
//    public List<SuggestedWorkerDto> getSuggestedWorkers(
//            @RequestParam(required = false) Long id,
//            @RequestParam(required = false) String skills,
//            @RequestParam(required = false) String location
//    ) {
//        return jobService.getSuggestedWorkers(id, skills, location);
//    }
    @Autowired
    private WorkerService workerService;

//    @GetMapping("/suggestedWorkers")
//    public List<Worker> getSuggestedWorkers(
//            @RequestParam(required = false) String jobId,
//            @RequestParam(required = false) String employerId,
//            @RequestParam(required = false) List<String> skills,
//            @RequestParam(required = false) String location) {
//        return workerService.findSuggestedWorkers(jobId, employerId, skills, location);
//    }

    @PostMapping("/shortlist")
    public String shortlistWorker(@RequestBody @Valid Shortlisted shortlist) {
        // Implementation would save to database
        return "Worker shortlisted";
    }

    @PostMapping
    public ResponseEntity<Worker> createWorker(@Valid @RequestBody Worker worker) {
        Worker savedWorker = workerService.saveWorker(worker);
        return ResponseEntity
                .created(URI.create("/workers/" + savedWorker.getWorkerId()))
                .body(savedWorker);
    }

    @GetMapping
    public ResponseEntity<List<Worker>> getAllWorkers() {
        return ResponseEntity.ok(workerService.getAllWorkers());
    }

    // 3. Get single worker by ID
    @GetMapping("/{workerId}")
    public ResponseEntity<Worker> getWorker(@PathVariable Long workerId) {
        Worker worker = workerService.getWorkerById(workerId);
        return ResponseEntity.ok(worker);
    }

    // 4. Update worker skills
//    @PutMapping("/{workerId}/skills")
//    public ResponseEntity<Map<String, Object>> updateSkills(
//            @PathVariable Long workerId,
//            @RequestBody Set<String> newSkills) {
//
//        Set<String> updatedSkills = workerService.updateSkills(workerId, newSkills);
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("message", "Skills updated successfully");
//        response.put("newSkills", updatedSkills);
//
//        return ResponseEntity.ok(response);
//    }

    // 5. Search workers by skill
    @GetMapping("/search")
    public ResponseEntity<List<Worker>> searchBySkill(
            @RequestParam String skill,
            @RequestParam(required = false) String location) {

        return ResponseEntity.ok(
                workerService.findBySkillAndLocation(skill, location)
        );
    }

    




//    @Autowired
//    private WorkerService workerService;
//
//    @GetMapping("/dashboard")
//    public ResponseEntity<?> getWorkerDashboard() {
//        return ResponseEntity.ok(workerService.getWorkerDashboard());
//    }

//    @PostMapping("/profile")
//    public ResponseEntity<WorkerProfile> createOrUpdateProfile(@RequestBody WorkerProfileDto profileDto) {
//        WorkerProfile updatedProfile = workerService.createOrUpdateProfile(profileDto);
//        return ResponseEntity.ok(updatedProfile);
//    }

//    @GetMapping("/profile")
//    public ResponseEntity<WorkerProfile> getProfile() {
//        WorkerProfile profile = workerService.getProfile();
//        return ResponseEntity.ok(profile);
//    }
//
//    @PostMapping("/availability")
//    public ResponseEntity<?> updateAvailability(@RequestBody AvailabilityRequest availabilityRequest) {
//        workerService.updateAvailability(availabilityRequest);
//        return ResponseEntity.ok("Availability updated successfully.");
//    }
//
//
//    @PostMapping("/leave")
//    public ResponseEntity<?> requestLeave(@RequestBody LeaveRequest leaveRequest) {
//        workerService.requestLeave(leaveRequest);
//        return ResponseEntity.ok("Leave requested successfully.");
//    }
//
//    @PutMapping("/account")
//    public ResponseEntity<?> updateAccountSettings(@RequestBody WorkerProfileDto accountSettings) {
//        workerService.updateAccountSettings(accountSettings);
//        return ResponseEntity.ok("Account settings updated successfully.");
//    }
    
    

}
