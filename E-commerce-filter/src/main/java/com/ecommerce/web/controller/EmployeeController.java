package com.ecommerce.web.controller;

import com.ecommerce.domain.service.employee.IEmployee;
import com.ecommerce.persistence.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private IEmployee service;

    @GetMapping
    public List<Employee> listEmployees() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> view(@PathVariable Long id) {
        Optional<Employee> getEmployee = service.findById(id);
        if (getEmployee.isPresent()) {
            return ResponseEntity.ok(getEmployee.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Employee> save(@NotBlank @RequestBody Employee employee) {
        Employee data = service.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @NotBlank @RequestBody Employee employee) {
        Optional<Employee> data = service.update(id, employee);
        if (data.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(data.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable Long id) {
        Optional<Employee> employee = service.delete(id);
        if (employee.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/by-office/{id}")
    public ResponseEntity<List<Object[]>> findByOffice(@PathVariable Long id){
        List<Object[]> employees = service.findByOffice(id);
        if(employees.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employees);
    }

}
