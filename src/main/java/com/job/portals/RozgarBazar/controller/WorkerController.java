package com.job.portals.RozgarBazar.controller;
import com.job.portals.RozgarBazar.model.*;
import com.job.portals.RozgarBazar.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    private WorkerService jobService;

    @GetMapping("/suggestedWorkers")
    public List<SuggestedWorkerDto> getSuggestedWorkers(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String skills,
            @RequestParam(required = false) String location
    ) {
        return jobService.getSuggestedWorkers(id, skills, location);
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
