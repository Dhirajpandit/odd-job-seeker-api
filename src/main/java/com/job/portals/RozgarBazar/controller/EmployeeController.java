package com.job.portals.RozgarBazar.controller;


import com.job.portals.RozgarBazar.entity.Employee;
import com.job.portals.RozgarBazar.model.EmployeeProfile;
import com.job.portals.RozgarBazar.model.EmployeeProfileDto;
import com.job.portals.RozgarBazar.model.WorkerProfile;
import com.job.portals.RozgarBazar.model.WorkerProfileDto;
import com.job.portals.RozgarBazar.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class EmployeeController {

//    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/post")
    public ResponseEntity<EmployeeProfile> createProfile(@RequestBody EmployeeProfileDto empProfile) {
        EmployeeProfile updatedProfile = employeeService.createProfile(empProfile);
        return ResponseEntity.ok(updatedProfile);
    }

//    @PostMapping("/post")
//    public Employee createEmployee(@RequestBody Employee employee) {
//        return employeeService.createProfile(employee);
//    }



    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployeesWithShiftTimings();
    }



    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

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
