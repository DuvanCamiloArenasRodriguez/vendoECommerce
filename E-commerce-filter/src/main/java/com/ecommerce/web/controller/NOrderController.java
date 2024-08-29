package com.ecommerce.web.controller;

import com.ecommerce.domain.service.norder.INOrder;
import com.ecommerce.persistence.entity.NOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nOrders")
public class NOrderController {
    @Autowired
    private INOrder service;

    @GetMapping
    public List<NOrder> listNOrder(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NOrder> view(@PathVariable Long id){
        Optional<NOrder> orderOpt = service.findById(id);
        if(orderOpt.isPresent()){
            return ResponseEntity.ok(orderOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<NOrder> save(@NotBlank @RequestBody NOrder nOrder){
        NOrder nOrderNew = service.save(nOrder);
        return ResponseEntity.status(HttpStatus.CREATED).body(nOrderNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NOrder> update(@PathVariable Long id, @NotBlank @RequestBody NOrder nOrder){
        Optional<NOrder> orderOpt = service.update(id, nOrder);
        if(orderOpt.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(orderOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<NOrder> delete(@PathVariable Long id){
        NOrder nOrder = new NOrder();
        nOrder.setId(id);
        Optional<NOrder> orderOpt = service.delete(id);
        if(orderOpt.isPresent()){
            return ResponseEntity.ok(orderOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    // buscar por estado
    @GetMapping("/by-status/{statusId}")
    public ResponseEntity<List<Object[]>> findByStatus(@PathVariable Long statusId) {
        List<Object[]> orders = service.findByStatus(statusId);
        if (orders.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(orders);
    }

    //buscar pedidos por rango de fecha
    //http://localhost:8080/api/nOrders/by-range?startDate=2024-08-01&endDate=2024-08-02
    @GetMapping("/by-range")
    public ResponseEntity<List<Object[]>> getOrdersByOrderDateRange(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        List<Object[]> orders = service.findOrdersByOrderDateRange(startDate, endDate);
        return orders.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(orders);
    }

    @GetMapping("/employee/{id}")
    public List<Object[]> getOrdersByEmployee(@PathVariable Long id) {
        return service.findOrdersByEmployee(id);
    }
}
