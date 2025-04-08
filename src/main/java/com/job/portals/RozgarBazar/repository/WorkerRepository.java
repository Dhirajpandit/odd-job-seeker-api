package com.job.portals.RozgarBazar.repository;

import com.job.portals.RozgarBazar.controller.WorkerController;
import com.job.portals.RozgarBazar.entity.Worker;
import jakarta.annotation.PostConstruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
//    @Query("SELECT w FROM Worker w " +
//            "WHERE (:id IS NULL OR w.id = :id) " +
//            "AND (:skills IS NULL OR w.skills LIKE %:skills%) " +
//            "AND (:location IS NULL OR w.location = :location)")
//    List<Worker> findSuggestedWorkers(
//            @Param("id") Long id,
//            @Param("skills") String skills,
//            @Param("location") String location
//    );
    List<Worker> workers = new ArrayList<>();

    @PostConstruct  // Initialize some sample data when app starts
    public default void init() {
        workers.addAll(Arrays.asList(
//                new Worker("w1", "John Doe", 4.5, Arrays.asList("plumbing", "electrical"), "New York"),
//                new Worker("w2", "Jane Smith", 4.8, Arrays.asList("cleaning", "cooking"), "Chicago"),
//                new Worker("w3", "Mike Johnson", 4.2, Arrays.asList("plumbing", "carpentry"), "New York"),
//                new Worker("w4", "Sarah Williams", 4.7, Arrays.asList("gardening", "landscaping"), "Chicago")
        ));
    }

    public default List<Worker> findAll() {
        return Collections.unmodifiableList(workers);
    }

    public default Optional<Worker> findById(String workerId) {
        return workers.stream()
                .filter(w -> w.getWorkerId().equals(workerId))
                .findFirst();
    }

//    public default List<Worker> findBySkillsAndLocation(List<String> skills, String location) {
//        return workers.stream()
//                .filter(w -> location == null || w.getLocation().equalsIgnoreCase(location))
//                .filter(w -> skills == null || skills.isEmpty() ||
//                        w.getSkills().stream().anyMatch(skills::contains))
//                .collect(Collectors.toList());
//    }


}