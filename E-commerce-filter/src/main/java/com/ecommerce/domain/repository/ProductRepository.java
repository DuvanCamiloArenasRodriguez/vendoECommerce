package com.ecommerce.domain.repository;

import com.ecommerce.persistence.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    @Query("SELECT p.id, p.name, p.stockQuantity, p.salePrice, p.rangeCode, p.productDescription, p.dimensions " +
            "FROM Product p " +
            "JOIN ProductRange pr ON p.rangeCode = pr " +
            "WHERE p.rangeCode.id = :id")
    List<Object[]> findProductByRangeId(@Param("id") Long id);

    @Query("SELECT p.id, p.name, p.stockQuantity, p.salePrice, p.rangeCode, p.productDescription, p.dimensions " +
            "FROM Product p " +
            "JOIN ProductRange pr ON p.rangeCode = pr " +
            "WHERE p.stockQuantity <= :threshold")
    List<Object[]> findProductByStockQuantity(@Param("threshold") Integer threshold);
}
