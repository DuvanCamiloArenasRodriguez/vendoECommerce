package com.ecommerce.domain.service.address;

import com.ecommerce.domain.repository.AddressRepository;
import com.ecommerce.persistence.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AddressImpl implements IAddress {
    @Autowired
    private AddressRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Address> findAll() {
        return (List<Address>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Address> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Address save(Address address) {
        return repository.save(address);
    }

    @Transactional
    @Override
    public Optional<Address> update(Long id, Address address) {
        Optional<Address> getAddress = repository.findById(id);
        if (getAddress.isPresent()) {
            Address newAddress = getAddress.orElseThrow();
            newAddress.setAddressLine1(address.getAddressLine1());
            newAddress.setAddressLine2(address.getAddressLine2());
            newAddress.setCity(address.getCity());
//            newAddress.setOffices(address.getOffices());
//            newAddress.setCustomers(address.getCustomers());
            return Optional.of(repository.save(newAddress));
        }
        return getAddress;
    }

    @Transactional
    @Override
    public Optional<Address> delete(Long id) {
        Optional<Address> getAddress = repository.findById(id);
        getAddress.ifPresent(repository::delete);
        return getAddress;
    }
}
