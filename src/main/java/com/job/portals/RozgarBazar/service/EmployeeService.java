package com.job.portals.RozgarBazar.service;

import com.job.portals.RozgarBazar.dto.Shortlisted;
import com.job.portals.RozgarBazar.dto.ShortlistedDto;
import com.job.portals.RozgarBazar.entity.Employee;
import com.job.portals.RozgarBazar.entity.ShiftTimings;
import com.job.portals.RozgarBazar.entity.ShortlistedEntity;
import com.job.portals.RozgarBazar.model.EmployeeProfile;
import com.job.portals.RozgarBazar.model.EmployeeProfileDto;
import com.job.portals.RozgarBazar.repository.EmployeeRepository;
import com.job.portals.RozgarBazar.repository.ShortlistedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Autowired
    private ShortlistedRepository shortlistedWorkerRepository;

    public ShortlistedDto shortlistWorker(Shortlisted request) {
        // Create a new ShortlistedWorker entity
        ShortlistedEntity shortlistedWorker = new ShortlistedEntity();
        shortlistedWorker.setEmployerId(request.getEmployerId());
        shortlistedWorker.setJobId(request.getJobId());
        shortlistedWorker.setWorkerId(request.getWorkerId());

        // Save to the database
        shortlistedWorkerRepository.save(shortlistedWorker);

        // Prepare the response
        ShortlistedDto response = new ShortlistedDto();
        response.setMessage("Worker shortlisted successfully");
        response.setEmployerId(request.getEmployerId());
        response.setJobId(request.getJobId());
        response.setWorkerId(request.getWorkerId());

        return response;
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
