package com.ecommerce.web.controller;

import com.ecommerce.domain.service.paymentMethod.IPaymentMethod;
import com.ecommerce.persistence.entity.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payment-methods")
public class PaymentMethodController {

    @Autowired
    private IPaymentMethod service;

    @GetMapping
    public List<PaymentMethod> listPaymentMethods() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentMethod> view(@PathVariable Long id) {
        Optional<PaymentMethod> getPaymentMethod = service.findById(id);
        if (getPaymentMethod.isPresent()) {
            return ResponseEntity.ok(getPaymentMethod.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<PaymentMethod> save(@NotBlank @RequestBody PaymentMethod paymentMethod) {
        PaymentMethod data = service.save(paymentMethod);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentMethod> update(@PathVariable Long id, @NotBlank @RequestBody PaymentMethod paymentMethod) {
        Optional<PaymentMethod> data = service.update(id, paymentMethod);
        if (data.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(data.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PaymentMethod> delete(@PathVariable Long id) {
        Optional<PaymentMethod> paymentMethod = service.delete(id);
        if (paymentMethod.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
}
