package com.ecommerce.domain.service.productrange;

import com.ecommerce.persistence.entity.ProductRange;

import java.util.List;
import java.util.Optional;

public interface IProductRange {
    List<ProductRange> findAll();
    Optional<ProductRange> findById(Long id);
    ProductRange save(ProductRange productRange);
    Optional<ProductRange> update(Long id, ProductRange productRange);
    Optional<ProductRange> delete(Long id);
}
