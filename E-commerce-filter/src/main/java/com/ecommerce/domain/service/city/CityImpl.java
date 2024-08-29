package com.ecommerce.domain.service.city;

import com.ecommerce.domain.repository.CityRepository;
import com.ecommerce.persistence.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CityImpl implements ICity {
    @Autowired
    private CityRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<City> findAll() {
        return (List<City>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<City> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public City save(City city) {
        return repository.save(city);
    }

    @Transactional
    @Override
    public Optional<City> update(Long id, City city) {
        Optional<City> getCity = repository.findById(id);
        if (getCity.isPresent()) {
            City newCity = getCity.orElseThrow();
            newCity.setName(city.getName());
//           newCity.setAddresses(city.getAddresses());
//            newCity.setCustomers(city.getCustomers());
            return Optional.of(repository.save(newCity));
        }
        return getCity;
    }

    @Transactional
    @Override
    public Optional<City> delete(Long id) {
        Optional<City> getCity = repository.findById(id);
        getCity.ifPresent(repository::delete);
        return getCity;
    }
}
