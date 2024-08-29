package com.ecommerce.domain.service.employee;

import com.ecommerce.persistence.entity.Employee;
import java.util.List;
import java.util.Optional;

public interface IEmployee {
    List<Employee> findAll();
    Optional<Employee> findById(Long id);
    Employee save(Employee employee);
    Optional<Employee> update(Long id, Employee employee);
    Optional<Employee> delete(Long id);
    //    Metodo para obtener empleados por oficina
    List<Object[]> findByOffice(Long officeId);

}