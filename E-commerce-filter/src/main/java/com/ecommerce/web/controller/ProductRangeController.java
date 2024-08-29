package com.ecommerce.web.controller;

import com.ecommerce.domain.service.productrange.IProductRange;
import com.ecommerce.persistence.entity.ProductRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productRanges")
public class ProductRangeController {
    @Autowired
    private IProductRange service;

    @GetMapping
    public List<ProductRange> listProductRanges() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductRange> view(@PathVariable Long id) {
        Optional<ProductRange> productRangeOpt = service.findById(id);
        if (productRangeOpt.isPresent()) {
            return ResponseEntity.ok(productRangeOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProductRange> save(@NotBlank @RequestBody ProductRange productRange) {
        ProductRange productRangeNew = service.save(productRange);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRangeNew);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductRange> update(@PathVariable Long id, @NotBlank @RequestBody ProductRange productRange) {
        Optional<ProductRange> productRangeOpt = service.update(id, productRange);
        if (productRangeOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(productRangeOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProductRange> delete(@PathVariable Long id) {
        ProductRange productRange = new ProductRange();
        productRange.setId(id);
        Optional<ProductRange> productRangeOpt = service.delete(id);
        if (productRangeOpt.isPresent()) {
            return ResponseEntity.ok(productRangeOpt.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }
}
