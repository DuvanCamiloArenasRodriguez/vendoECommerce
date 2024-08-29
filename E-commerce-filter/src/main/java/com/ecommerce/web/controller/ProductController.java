package com.ecommerce.web.controller;

import com.ecommerce.domain.service.product.IProduct;
import com.ecommerce.persistence.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private IProduct service;

    @GetMapping
    public List<Product> listProducts() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> view(@PathVariable Long id) {
        Optional<Product> productOpt = service.findById(id);
        if (productOpt.isPresent()) {
            return ResponseEntity.ok(productOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Product> save(@NotBlank @RequestBody Product product) {
        Product saved = service.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id,@NotBlank @RequestBody Product product) {
        Optional<Product> productOpt = service.update(id, product);
        if (productOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(productOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable Long id) {
        Product product = new Product();
        product.setId(id);
        Optional<Product> productOpt = service.delete(id);
        if (productOpt.isPresent()) {
            return ResponseEntity.ok(productOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    //    Buscar por gama
    @GetMapping("by-range/{rangeId}")
    public ResponseEntity<List<Object[]>> findByRange(@PathVariable Long rangeId) {
        List<Object[]> products = service.findProductByRange(rangeId);
        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }

    //    Buscar por stock
    @GetMapping("by-low-stock/{threshold}")
    public ResponseEntity<List<Object[]>> findByLowStock(@PathVariable Integer threshold) {
        List<Object[]> productStock = service.findProductByStock(threshold);
        if (productStock.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productStock);
    }

}
