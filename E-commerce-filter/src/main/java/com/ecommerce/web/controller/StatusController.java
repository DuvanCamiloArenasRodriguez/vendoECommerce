package com.ecommerce.web.controller;

import com.ecommerce.domain.service.status.IStatus;
import com.ecommerce.persistence.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/status")
public class StatusController {
    @Autowired
    private IStatus service;

    @GetMapping
    public List<Status> listStatus() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Status> view(@PathVariable Long id) {
        Optional<Status> statusOpt = service.findById(id);
        if (statusOpt.isPresent()) {
            return ResponseEntity.ok(statusOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Status> save(@RequestBody Status status) {
        Status saved = service.save(status);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status> update(@PathVariable Long id, @RequestBody Status status) {
        Optional<Status> statusOpt = service.update(id, status);
        if (statusOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(statusOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Status> delete(@PathVariable Long id) {
        Status status = new Status();
        status.setId(id);
        Optional<Status> statusOpt = service.delete(id);
        if (statusOpt.isPresent()) {
            return ResponseEntity.ok(statusOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();

    }
}
