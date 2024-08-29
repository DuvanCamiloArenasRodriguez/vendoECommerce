package com.ecommerce.domain.service.product;

import com.ecommerce.persistence.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProduct {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    Optional<Product> update(Long id, Product product);
    Optional<Product> delete(Long id);
    //    Metodo para filtrar producto por gama
    List<Object[]> findProductByRange(Long rangeId);

    //    Método para filtrar producto por bajo stock
    List<Object[]> findProductByStock(Integer threshold);
}
