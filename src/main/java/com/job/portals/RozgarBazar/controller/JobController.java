//package com.job.portals.RozgarBazar.controller;
//
//import com.job.portals.RozgarBazar.entity.Employee;
//import com.job.portals.RozgarBazar.model.EmployeeProfileDto;
//import com.job.portals.RozgarBazar.service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/jobs")
//public class JobController {
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @PostMapping("/post")
//    public ResponseEntity<Employee> createProfile(@RequestBody EmployeeProfileDto empProfile) {
//        Employee employee = employeeService.createProfile(empProfile);
//        return ResponseEntity.ok(employee);
//    }
//}
