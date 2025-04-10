package com.job.portals.RozgarBazar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.portals.RozgarBazar.entity.Employee;
import com.job.portals.RozgarBazar.entity.ShiftTimings;
import com.job.portals.RozgarBazar.model.EmployeeProfileDto;
import com.job.portals.RozgarBazar.repository.EmployeeRepository;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createProfile(EmployeeProfileDto employeeProfileDto) {
        Employee employee = new Employee();
        employee.setLocation(employeeProfileDto.getLocation());
        employee.setPayRate(employeeProfileDto.getPayRate());
        employee.setJobDate(employeeProfileDto.getJobDate());
        employee.setJobTitle(employeeProfileDto.getJobTitle());
        employee.setJobDescription(employeeProfileDto.getJobDescription());
        employee.setSkillsRequired(employeeProfileDto.getSkillsRequired());
        ShiftTimings shiftTimings = new ShiftTimings();
        shiftTimings.setStartTime(employeeProfileDto.getShiftTimings().getStartTime());
        shiftTimings.setEndTime(employeeProfileDto.getShiftTimings().getEndTime());
        employee.setShiftTimings(shiftTimings);
        return employeeRepository.save(employee);
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
