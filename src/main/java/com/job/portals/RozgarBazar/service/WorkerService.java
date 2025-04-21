package com.job.portals.RozgarBazar.service;

import com.job.portals.RozgarBazar.entity.Job;
import com.job.portals.RozgarBazar.entity.Worker;
import com.job.portals.RozgarBazar.model.*;
import com.job.portals.RozgarBazar.repository.JobRepository;
import com.job.portals.RozgarBazar.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WorkerService {

//    public WorkerProfile getProfile() {
//        // Mock implementation for getting the profile
//        /*return new WorkerProfile(null,"John Doe", "john.doe@example.com", Arrays.asList("Java", "Spring Boot"), true,"Pune",
//                Arrays.asList(new Experience("Qloudx","2022","2026","Pune","412207")));*/
//        return new WorkerProfile();
//    }
//
//
//    public EmployeeProfile getEmployeeProfile() {
//        // Mock implementation for getting the profile
//        /*return new WorkerProfile(null,"John Doe", "john.doe@example.com", Arrays.asList("Java", "Spring Boot"), true,"Pune",
//                Arrays.asList(new Experience("Qloudx","2022","2026","Pune","412207")));*/
//        return new EmployeeProfile();
//    }
//
//    public EmployeeProfile createProfile(EmployeeProfileDto employeeProfileDto) {
//
//        return new EmployeeProfile();
//    }
//
//    public void updateAvailability(AvailabilityRequest availabilityRequest) {
//        // Logic to update worker availability
//    }
//
//    public void requestLeave(LeaveRequest leaveRequest) {
//        // Logic to handle leave requests
//    }
//
//    public void updateAccountSettings(WorkerProfileDto accountSettings) {
//        // Logic to update account settings
//    }
//
//    public Object getWorkerDashboard() {
//        // Logic to return worker dashboard data
//        return "Worker Dashboard Data (Mock)";
//    }
//
//    @Autowired
//    private WorkerRepository workerRepository;
//
//    public List<SuggestedWorkerDto> getSuggestedWorkers(Long id, String skills, String location) {
//        // Fetch workers based on criteria
//        return workerRepository.findSuggestedWorkers(id, skills, location)
//                .stream()
//                .map(this::mapToSuggestedWorkerResponse)
//                .collect(Collectors.toList());
//    }
//
//    private SuggestedWorkerDto mapToSuggestedWorkerResponse(Worker worker) {
//        SuggestedWorkerDto response = new SuggestedWorkerDto();
//        response.setWorkerId(worker.getWorkerId());
//        response.setName(worker.getName());
//        response.setRating(worker.getRating());
//        response.setSkills(worker.getSkills());
//        return response;
//    }


    private final WorkerRepository workerRepository;
    private final JobRepository jobRepository;

    public WorkerService(WorkerRepository workerRepository, JobRepository jobRepository) {
        this.workerRepository = workerRepository;
        this.jobRepository = jobRepository;
    }

    public List<Worker> getSuggestedWorkers(String jobId, String employerId, Set<String> skills, String location) {
        // If jobId is provided, get criteria from the job
        if (jobId != null) {
            Job job = jobRepository.findById(jobId)
                    .orElseThrow(() -> new RuntimeException("Job not found"));

            if (skills == null) skills = job.getSkillsRequired();
            if (location == null) location = job.getLocation();
        }

        return workerRepository.findSuggestedWorkers(location, skills);
    }

    public Worker saveWorker(Worker worker) {
        // Ensure skills are lowercase and trimmed
        if (worker.getSkills() != null) {
            Set<String> cleanedSkills = worker.getSkills().stream()
                    .map(skill -> skill.trim().toLowerCase())
                    .collect(Collectors.toSet());
            worker.setSkills(cleanedSkills);
        }
        return workerRepository.save(worker);
    }

    public List<Worker> getAllWorkers() {
        return workerRepository.findAll();
    }


    public Optional<Worker> getWorkerById(Long workerId) {
        return workerRepository.findById(workerId);
    }


//    public Set<String> updateSkills(Long workerId, Set<String> newSkills) {
//        Worker worker = workerRepository.findById(workerId)
//                .orElseThrow(() -> new ResourceNotFoundException("Worker not found with id: " + workerId));
//
//        // Clean and validate skills
//        Set<String> cleanedSkills = newSkills.stream()
//                .filter(skill -> skill != null && !skill.trim().isEmpty())
//                .map(String::trim)
//                .collect(Collectors.toSet());
//
//        if (cleanedSkills.isEmpty()) {
//            throw new IllegalArgumentException("At least one valid skill must be provided");
//        }
//
//        worker.setSkills(cleanedSkills);
//        Worker updatedWorker = workerRepository.save(worker);
//
//        return updatedWorker.getSkills();
//    }


    public List<Worker> findBySkillAndLocation(String skill, String location) {
        if (skill == null || skill.trim().isEmpty()) {
            throw new IllegalArgumentException("Skill parameter is required");
        }

        String cleanedSkill = skill.trim().toLowerCase();
        String cleanedLocation = location != null ? location.trim() : null;

        if (cleanedLocation != null && !cleanedLocation.isEmpty()) {
            return workerRepository.findBySkillsContainingAndLocationIgnoreCase(cleanedSkill, cleanedLocation);
        } else {
            return workerRepository.findBySkillsContaining(cleanedSkill);
        }
    }

    // Additional helper method

    public boolean workerExists(Long workerId) {
        return workerRepository.existsById(workerId);
    }
//    public List<Worker> findSuggestedWorkers(/* parameters */) {
//        return workerRepository.findAll().stream()
//                .filter(worker -> location == null || worker.getLocation().equals(location))
//                .filter(worker -> skills == null || worker.getSkills().containsAny(skills))
//                .collect(Collectors.toList());
//    }
}
