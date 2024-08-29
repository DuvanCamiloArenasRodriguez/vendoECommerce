package com.ecommerce.domain.service.customer;

import com.ecommerce.domain.repository.CustomerRepository;
import com.ecommerce.persistence.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerImpl implements ICustomer {
    @Autowired
    private CustomerRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Customer> findAll() {
        return (List<Customer>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Customer> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    @Transactional
    @Override
    public Optional<Customer> update(Long id, Customer customer) {
        Optional<Customer> getCustomer = repository.findById(id);
        if (getCustomer.isPresent()) {
            Customer newCustomer = getCustomer.orElseThrow();
            newCustomer.setFirstName(customer.getFirstName());
            newCustomer.setLastName1(customer.getLastName1());
            newCustomer.setLastName2(customer.getLastName2());
            newCustomer.setEmail(customer.getEmail());
            newCustomer.setCity(customer.getCity());
            newCustomer.setAddress(customer.getAddress());
            newCustomer.setSalesRep(customer.getSalesRep());
            return Optional.of(repository.save(newCustomer));
        }
        return getCustomer;
    }

    @Transactional
    @Override
    public Optional<Customer> delete(Long id) {
        Optional<Customer> getCustomer = repository.findById(id);
        getCustomer.ifPresent(customer -> repository.delete(customer));
        return getCustomer;
    }
    // buscar por ciudad
    @Transactional(readOnly = true)
    @Override
    public List<Object[]> findByCity(Long cityId) {
        return repository.findCustomerDataByCityId(cityId);
    }

    // buscar por pedidos pendientes
    @Transactional(readOnly = true)
    @Override
    public List<Object[]> findCustomersWithPendingOrders() {
        return repository.findCustomersWithPendingOrders();
    }
}
