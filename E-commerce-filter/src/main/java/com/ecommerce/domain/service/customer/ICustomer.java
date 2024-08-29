package com.ecommerce.domain.service.customer;

import com.ecommerce.persistence.entity.Customer;
import java.util.List;
import java.util.Optional;

public interface ICustomer {
    List<Customer> findAll();
    Optional<Customer> findById(Long id);
    Customer save(Customer customer);
    Optional<Customer> update(Long id, Customer customer);
    Optional<Customer> delete(Long id);
    // Método para obtener clientes por ciudad
    List<Object[]> findByCity(Long cityId);
    // Método para obtener clientes por ID junto con el estado de sus pedidos
    List<Object[]> findCustomersWithPendingOrders();
}
