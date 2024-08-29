package com.ecommerce.domain.service.office;

import com.ecommerce.persistence.entity.Office;
import java.util.List;
import java.util.Optional;

public interface IOffice {
    List<Office> findAll();
    Optional<Office> findById(Long id);
    Office save(Office office);
    Optional<Office> update(Long id, Office office);
    Optional<Office> delete(Long id);
}