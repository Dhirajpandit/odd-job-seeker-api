//package com.job.portals.RozgarBazar.service;
//import com.job.portals.RozgarBazar.dto.Hiring;
//import com.job.portals.RozgarBazar.dto.HiringDto;
//import com.job.portals.RozgarBazar.entity.HiringWorker;
//import com.job.portals.RozgarBazar.entity.Job;
//import com.job.portals.RozgarBazar.entity.Worker;
//import com.job.portals.RozgarBazar.repository.HiringRepository;
//import com.job.portals.RozgarBazar.repository.JobRepository;
//import com.job.portals.RozgarBazar.repository.WorkerRepository;
//import jakarta.persistence.EntityNotFoundException;
//import jakarta.transaction.Transactional;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.Date;
//
//
//@Service
//@RequiredArgsConstructor
//public class HiringService {
//
//    private final WorkerRepository workerRepo;
//    private final JobRepository jobRepo;
//    private final HiringRepository hiringRepo;
//
//    public static HiringDto hireWorker(Hiring request) {
//        // Validate
////        if (!request.isConfirmHire()) {
////            throw new RuntimeException("Hiring not confirmed");
////        }
////        if (hiringRepo.existsByJobIdAndWorkerId(request.getJobId(), request.getWorkerId())) {
////            throw new RuntimeException("Worker already hired for this job");
////        }
//
//        // Find worker
////        Worker worker = workerRepo.findById(request.getWorkerId())
////                .orElseThrow(() -> new RuntimeException("Worker not found"));
////
////        // Find job
////        Job job = jobRepo.findById(request.getJobId())
////                .orElseThrow(() -> new RuntimeException("Job not found"));
//
//        // Create record
////        HiringWorker record = new HiringWorker();
////        record.setEmployerId(request.getEmployerId());
////        record.setWorkerId(worker);
////        record.setJobId(job);
////        record.setHireDate(new Date());
////
////        HiringWorker savedRecord = hiringRepo.save(record);
////
////        // Prepare response
////        HiringDto response = new HiringDto();
////        response.setStatus("Hired successfully");
////        response.setHireId(savedRecord.getId());
////        response.setWorkerName(worker.getName());
////        response.setJobTitle(job.getTitle());
////        response.setHireDate(new Date().toString());
////
////        return response;
//    }
//
//}
