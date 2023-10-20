package net.javaguides.springbootbackend.repository;

import net.javaguides.springbootbackend.model.Employee;
import net.javaguides.springbootbackend.model.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    // Find all job offers associated with a specific employee
    List<JobOffer> findByJobOffers(Employee employee);
}

