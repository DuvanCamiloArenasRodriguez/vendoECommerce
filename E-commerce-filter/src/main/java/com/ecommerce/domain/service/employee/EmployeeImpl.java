package com.ecommerce.domain.service.employee;

import com.ecommerce.domain.repository.EmployeeRepository;
import com.ecommerce.persistence.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeImpl implements IEmployee {
    @Autowired
    private EmployeeRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Employee> findAll() {
        return (List<Employee>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return repository.save(employee);
    }

    @Transactional
    @Override
    public Optional<Employee> update(Long id, Employee employee) {
        Optional<Employee> getEmployee = repository.findById(id);
        if (getEmployee.isPresent()) {
            Employee newEmployee = getEmployee.orElseThrow();
            newEmployee.setFirstName(employee.getFirstName());
            newEmployee.setLastName1(employee.getLastName1());
            newEmployee.setLastName2(employee.getLastName2());
            newEmployee.setEmail(employee.getEmail());
            newEmployee.setOffice(employee.getOffice());
            return Optional.of(repository.save(newEmployee));
        }
        return getEmployee;
    }

    @Transactional
    @Override
    public Optional<Employee> delete(Long id) {
        Optional<Employee> getEmployee = repository.findById(id);
        getEmployee.ifPresent(repository::delete);
        return getEmployee;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Object[]> findByOffice(Long officeId) {
        return repository.findByOfficeId(officeId);
    }
}
