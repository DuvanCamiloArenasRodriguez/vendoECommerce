package com.ecommerce.domain.service.phone;

import com.ecommerce.persistence.entity.Phone;

import java.util.List;
import java.util.Optional;

public interface IPhone {
    List<Phone> findAll();
    Optional<Phone> findById(Long id);
    Phone save(Phone phone);
    Optional<Phone> update(Long id, Phone phone);
    Optional<Phone> delete(Long id);
}
