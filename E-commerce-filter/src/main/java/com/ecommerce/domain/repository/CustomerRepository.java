package com.ecommerce.domain.repository;

import com.ecommerce.persistence.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    //FILTRO DE CLIENTE POR CIUDAD
    @Query("SELECT c.id, c.firstName, c.lastName1, c.lastName2, c.email, c.city, c.address, c.salesRep " +
            "FROM Customer c " +
            "WHERE c.city.id = :id")
    List<Object[]> findCustomerDataByCityId(@Param("id") Long id);

    //FILTRO DE CLIENTE POR ESTADO PEDIDO
    @Query("SELECT DISTINCT c.id, c.firstName, c.lastName1, c.lastName2, c.email, c.city, c.address, c.salesRep " +
            "FROM NOrder o " +
            "JOIN o.customerCodeOr c " +
            "JOIN o.statusCodeOr s " +
            "WHERE s.id = 1")
    List<Object[]> findCustomersWithPendingOrders();
}
