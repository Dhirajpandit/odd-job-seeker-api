package com.job.portals.RozgarBazar.service;
import com.job.portals.RozgarBazar.dto.Hiring;
import com.job.portals.RozgarBazar.dto.HiringDto;
import com.job.portals.RozgarBazar.entity.HiringWorker;
import com.job.portals.RozgarBazar.repository.HiringRepository;
import com.job.portals.RozgarBazar.repository.WorkerRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@Transactional

public class HiringService {

    @Autowired
    private HiringRepository hiredWorkerRepository;

    @Autowired
    private WorkerRepository workerRepository;

//    @Autowired
//    private JobRepository jobRepository;

    public HiringDto processHiring(Hiring request) {
        // Validate hiring confirmation
        if (!request.isHiringConfirmation()) {
            throw new IllegalArgumentException("Hiring not confirmed");
        }

        // Check if worker is already hired for this job
        if (hiredWorkerRepository.existsByJobIdAndWorkerId(request.getJobId(), request.getWorkerId())) {
            throw new IllegalStateException("Worker already hired for this job");
        }

        // Verify worker and job exist
        workerRepository.findById(request.getWorkerId())
                .orElseThrow(() -> new EntityNotFoundException("Worker not found"));

//        jobRepository.findById(request.getJobId())
//                .orElseThrow(() -> new EntityNotFoundException("Job not found"));

        // Create hiring record
        HiringWorker hiredWorker = new HiringWorker();
        hiredWorker.setEmployerId(request.getEmployerId());
        hiredWorker.setJobId(request.getJobId());
        hiredWorker.setWorkerId(request.getWorkerId());
        hiredWorker.setHireDate(LocalDateTime.now());
        hiredWorker.setActive(true);

        hiredWorkerRepository.save(hiredWorker);

        return HiringDto.builder()
                .message("Successfully hired worker " + request.getWorkerId())
                .employerId(request.getEmployerId())
                .jobId(request.getJobId())
                .workerId(request.getWorkerId())
                .hireDate(hiredWorker.getHireDate())
                .build();
    }
}
