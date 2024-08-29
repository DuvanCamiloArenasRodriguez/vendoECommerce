package com.ecommerce.domain.repository;

import com.ecommerce.persistence.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
