package com.ecommerce.domain.service.address;

import com.ecommerce.persistence.entity.Address;
import java.util.List;
import java.util.Optional;

public interface IAddress {
    List<Address> findAll();
    Optional<Address> findById(Long id);
    Address save(Address address);
    Optional<Address> update(Long id, Address address);
    Optional<Address> delete(Long id);
}
