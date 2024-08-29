package com.ecommerce.web.controller;

import com.ecommerce.domain.service.phone.IPhone;
import com.ecommerce.persistence.entity.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/phones")
public class PhoneController {
    @Autowired
    private IPhone service;

    @GetMapping
    public List<Phone> listPhones(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Phone> view(@PathVariable Long id){
        Optional<Phone> phoneOpt = service.findById(id);
        if(phoneOpt.isPresent()){
            return ResponseEntity.ok(phoneOpt.orElseThrow());

        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Phone> save(@NotBlank @RequestBody Phone phone){
        Phone saved = service.save(phone);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Phone> update(@PathVariable Long id, @NotBlank @RequestBody Phone phone){
        Optional<Phone> phoneOpt = service.update(id,phone);
        if(phoneOpt.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(phoneOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Phone> delete(@PathVariable Long id) {
        System.out.println(id + "--------------------------------");
        Optional<Phone> phoneOpt = service.delete(id);
        if(phoneOpt.isPresent()){
            return ResponseEntity.ok(phoneOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

}
