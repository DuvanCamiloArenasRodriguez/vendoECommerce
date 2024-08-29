package com.ecommerce.web.controller;

import com.ecommerce.domain.service.city.ICity;
import com.ecommerce.persistence.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private ICity service;

    @GetMapping
    public List<City> listCities() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> view(@PathVariable Long id) {
        Optional<City> getCity = service.findById(id);
        if (getCity.isPresent()) {
            return ResponseEntity.ok(getCity.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<City> save(@NotBlank @RequestBody City city) {
        City data = service.save(city);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> update(@PathVariable Long id, @NotBlank @RequestBody City city) {
        Optional<City> data = service.update(id, city);
        if (data.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(data.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<City> delete(@PathVariable Long id) {
        Optional<City> city = service.delete(id);
        if (city.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
}
