package com.ecommerce.domain.repository;

import com.ecommerce.persistence.entity.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;import org.springframework.data.repository.query.Param;import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    @Query("SELECT e.id, e.firstName, e.lastName1, e.lastName2, e.email, e.office" +
            " FROM Employee e " +
            "WHERE e.office.id = :id")
    List<Object[]> findByOfficeId(@Param("id") Long id);
}
