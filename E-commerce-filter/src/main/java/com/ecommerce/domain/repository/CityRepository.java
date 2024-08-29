package com.ecommerce.domain.repository;

import com.ecommerce.persistence.entity.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {
}

