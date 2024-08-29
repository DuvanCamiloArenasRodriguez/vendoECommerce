package com.ecommerce.domain.service.city;

import com.ecommerce.persistence.entity.City;
import java.util.List;
import java.util.Optional;

public interface ICity {
    List<City> findAll();
    Optional<City> findById(Long id);
    City save(City city);
    Optional<City> update(Long id, City city);
    Optional<City> delete(Long id);
}
