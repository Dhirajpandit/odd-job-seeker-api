package com.job.portals.RozgarBazar.controller;
import com.job.portals.RozgarBazar.model.AvailabilityRequest;
import com.job.portals.RozgarBazar.model.LeaveRequest;
import com.job.portals.RozgarBazar.model.WorkerProfile;
import com.job.portals.RozgarBazar.model.WorkerProfileDto;
import com.job.portals.RozgarBazar.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @GetMapping("/dashboard")
    public ResponseEntity<?> getWorkerDashboard() {
        return ResponseEntity.ok(workerService.getWorkerDashboard());
    }

//    @PostMapping("/profile")
//    public ResponseEntity<WorkerProfile> createOrUpdateProfile(@RequestBody WorkerProfileDto profileDto) {
//        WorkerProfile updatedProfile = workerService.createOrUpdateProfile(profileDto);
//        return ResponseEntity.ok(updatedProfile);
//    }

    @GetMapping("/profile")
    public ResponseEntity<WorkerProfile> getProfile() {
        WorkerProfile profile = workerService.getProfile();
        return ResponseEntity.ok(profile);
    }

    @PostMapping("/availability")
    public ResponseEntity<?> updateAvailability(@RequestBody AvailabilityRequest availabilityRequest) {
        workerService.updateAvailability(availabilityRequest);
        return ResponseEntity.ok("Availability updated successfully.");
    }


    @PostMapping("/leave")
    public ResponseEntity<?> requestLeave(@RequestBody LeaveRequest leaveRequest) {
        workerService.requestLeave(leaveRequest);
        return ResponseEntity.ok("Leave requested successfully.");
    }

    @PutMapping("/account")
    public ResponseEntity<?> updateAccountSettings(@RequestBody WorkerProfileDto accountSettings) {
        workerService.updateAccountSettings(accountSettings);
        return ResponseEntity.ok("Account settings updated successfully.");
    }

}
