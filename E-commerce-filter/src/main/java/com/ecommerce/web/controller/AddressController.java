package com.ecommerce.web.controller;

import com.ecommerce.domain.service.address.IAddress;
import com.ecommerce.persistence.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private IAddress service;

    @GetMapping
    public List<Address> listAddresses() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> view(@PathVariable Long id) {
        Optional<Address> getAddress = service.findById(id);
        if (getAddress.isPresent()) {
            return ResponseEntity.ok(getAddress.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Address> save(@NotBlank @RequestBody Address address) {
        Address data = service.save(address);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> update(@PathVariable Long id, @NotBlank @RequestBody Address address) {
        Optional<Address> data = service.update(id, address);
        if (data.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(data.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Address> delete(@PathVariable Long id) {
        Optional<Address> address = service.delete(id);
        if (address.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
}