package com.ecommerce.web.controller;

import com.ecommerce.domain.service.office.IOffice;
import com.ecommerce.persistence.entity.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/offices")
public class OfficeController {

    @Autowired
    private IOffice service;

    @GetMapping
    public List<Office> listOffices() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Office> view(@PathVariable Long id) {
        Optional<Office> getOffice = service.findById(id);
        if (getOffice.isPresent()) {
            return ResponseEntity.ok(getOffice.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Office> save(@NotBlank @RequestBody Office office) {
        Office data = service.save(office);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Office> update(@PathVariable Long id, @NotBlank @RequestBody Office office) {
        Optional<Office> data = service.update(id, office);
        if (data.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(data.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Office> delete(@PathVariable Long id) {
        System.out.println(id + "--------------------------------");
        Optional<Office> office = service.delete(id);
        if (office.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
}
