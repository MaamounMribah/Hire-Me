package net.javaguides.springbootbackend.controller;

import net.javaguides.springbootbackend.exception.ResourceNotFoundException;
import net.javaguides.springbootbackend.model.Employee;
import net.javaguides.springbootbackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins ="*")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository ;


    //get All employees
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){

        return employeeRepository.findAll();
    }
    //get employee by id rest api
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id ){

        Employee employee =employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not existe"+ id));

        return ResponseEntity.ok(employee);
    }

    //create employee rest api
    @PostMapping("/employees")
    public  Employee createEmployee(@RequestBody Employee employee){

        return employeeRepository.save(employee);
    }
    //update employee rest api
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id ,@RequestBody Employee employeeDetails){

        Employee employee =employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not existe"+ id));

        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());

        Employee UpdateEmployee = employeeRepository.save(employee) ;

        return ResponseEntity.ok(UpdateEmployee) ;
    }

    //delete employee rest api
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){

        Employee employee =employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee not existe"+ id));

        employeeRepository.delete(employee);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
