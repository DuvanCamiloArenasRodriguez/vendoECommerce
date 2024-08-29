package com.ecommerce.web.controller;

import com.ecommerce.domain.service.customer.ICustomer;
import com.ecommerce.persistence.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private ICustomer service;

    @GetMapping
    public List<Customer> listCustomers() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> view(@PathVariable Long id) {
        Optional<Customer> getCustomer = service.findById(id);
        if (getCustomer.isPresent()) {
            return ResponseEntity.ok(getCustomer.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Customer> save(@NotBlank @RequestBody Customer customer) {
        Customer data = service.save(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @NotBlank @RequestBody Customer customer) {
        Optional<Customer> data = service.update(id, customer);
        if (data.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(data.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> delete(@PathVariable Long id) {
        Optional<Customer> customer = service.delete(id);
        if (customer.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }

    //buscar por ciudad
    @GetMapping("/by-city/{cityId}")
    public ResponseEntity<List<Object[]>> findByCity(@PathVariable Long cityId) {
        List<Object[]> customers = service.findByCity(cityId);
        if (customers.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(customers);
    }

    //buscar por pedido pendiente
    @GetMapping("/pending-orders")
    public List<Object[]> getCustomersWithPendingOrders() {
        return service.findCustomersWithPendingOrders();
    }
}
