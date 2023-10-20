package net.javaguides.springbootbackend.controller;

import jakarta.persistence.EntityNotFoundException;
import net.javaguides.springbootbackend.model.Employee;
import net.javaguides.springbootbackend.model.JobOffer;
import net.javaguides.springbootbackend.repository.EmployeeRepository;
import net.javaguides.springbootbackend.repository.JobOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/joboffers")
public class JobOfferController {
    @Autowired
    private JobOfferRepository jobOfferRepository;

    @Autowired
    private EmployeeRepository employeeRepository;


    @PostMapping("/pub")
    public JobOffer createJobOffer(@RequestBody JobOffer jobOffer) {
        return jobOfferRepository.save(jobOffer);
    }

    @GetMapping("/AllJobOffers")
    public List<JobOffer> getAllJobOffers() {
        return jobOfferRepository.findAll();
    }

    /*public List<JobOffer> getJobOffersByEmployee(@PathVariable Long employeeId) {
        // Find the employee by ID first
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with ID: " + employeeId));

        // Retrieve job offers related to the employee
        return jobOfferRepository.findByEmployee(employee);
    }*/
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<Employee> getJobOffersByEmployee(@PathVariable Long employeeId) {
        // Find the employee by ID first
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with ID: " + employeeId));

        // Retrieve job offers related to the employee
        return ResponseEntity.ok(employee);
    }
}
