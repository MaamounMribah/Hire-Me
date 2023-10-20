package net.javaguides.springbootbackend.repository;

import net.javaguides.springbootbackend.model.Employee;
import net.javaguides.springbootbackend.model.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobOfferRepository extends JpaRepository<JobOffer, Long> {

    // Find all job offers related to a specific employee
    List<JobOffer> findByEmployee(Employee employee);
}
