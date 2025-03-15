package com.job.portals.RozgarBazar.service;

import com.job.portals.RozgarBazar.entity.Employee;
import com.job.portals.RozgarBazar.model.EmployeeProfile;
import com.job.portals.RozgarBazar.model.EmployeeProfileDto;
import com.job.portals.RozgarBazar.model.ShiftTimings;
import com.job.portals.RozgarBazar.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.job.portals.RozgarBazar.repository.ShiftTimingsRepository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeProfile createProfile(EmployeeProfileDto employeeProfileDto) {

        return new EmployeeProfile();
    }

//    public Employee saveEmployeeWithShiftTimings(Employee employee) {
//        // Save the employee
//
//        // Save the shift timings
////        List<ShiftTimings> shiftTimings = employee.getShiftTimings();
////        if (shiftTimings != null) {
////            for (ShiftTimings shift : shiftTimings) {
////                shift.setEmployee(savedEmployee);
////                ShiftTimingsRepository.save(shift);
////            }
////        }
//
//        return employeeRepository.save(employee);
//    }

    public List<Employee> getAllEmployeesWithShiftTimings() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
