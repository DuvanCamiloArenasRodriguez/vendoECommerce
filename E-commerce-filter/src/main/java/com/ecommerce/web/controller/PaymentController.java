package com.ecommerce.web.controller;

import com.ecommerce.domain.service.payment.IPayment;
import com.ecommerce.persistence.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private IPayment service;

    @GetMapping
    public List<Payment> listPayments() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> view(@PathVariable Long id) {
        Optional<Payment> getPayment = service.findById(id);
        if (getPayment.isPresent()) {
            return ResponseEntity.ok(getPayment.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Payment> save(@NotBlank @RequestBody Payment payment) {
        Payment data = service.save(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> update(@PathVariable Long id, @NotBlank @RequestBody Payment payment) {
        Optional<Payment> data = service.update(id, payment);
        if (data.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(data.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Payment> delete(@PathVariable Long id) {
        Optional<Payment> payment = service.delete(id);
        if (payment.isPresent()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }

    //PAGO POR CLIENTE
    @GetMapping("/by-customer/{id}")
    public ResponseEntity<List<Object[]>> findPaymentsByCustomer(@PathVariable Long id) {
        List<Object[]> payments = service.findPaymentsByCustomer(id);
        if (payments.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(payments);
    }

    //PAGO POR METODO DE PAGO
    @GetMapping("/by-method/{id}")
    public ResponseEntity<List<Object[]>> findPaymentsByPaymentMethod(@PathVariable Long id) {
        List<Object[]> payments = service.findPaymentsByPaymentMethod(id);
        if (payments.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(payments);
    }
}
