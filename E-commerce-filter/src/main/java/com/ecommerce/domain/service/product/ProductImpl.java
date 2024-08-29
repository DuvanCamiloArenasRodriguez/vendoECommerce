package com.ecommerce.domain.service.product;

import com.ecommerce.domain.repository.ProductRepository;
import com.ecommerce.persistence.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductImpl implements IProduct{

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Product> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Transactional
    @Override
    public Optional<Product> update(Long id, Product product) {
        Optional<Product> productOpt = repository.findById(id);
        if (productOpt.isPresent()) {
            Product productItem = productOpt.orElseThrow();
            productItem.setName(product.getName());
            productItem.setStockQuantity(product.getStockQuantity());
            productItem.setSalePrice(product.getSalePrice());
//            productItem.setSupplierPrice(product.getSupplierPrice());
            productItem.setProductDescription(product.getProductDescription());
            productItem.setDimensions(product.getDimensions());
            productItem.setRangeCode(product.getRangeCode());
            return Optional.of(repository.save(productItem));
        }
        return productOpt;
    }

    @Transactional
    @Override
    public Optional<Product> delete(Long id) {
        Optional<Product> productOpt = repository.findById(id);
        productOpt.ifPresent(product -> {
            repository.delete(product);
        });
        return productOpt;
    }

    //    Buscar por gama
    @Transactional(readOnly = true)
    @Override
    public List<Object[]> findProductByRange(Long rangeId) {
        return repository.findProductByRangeId(rangeId);
    }

    //  Buscar por bajo stock
    @Transactional(readOnly = true)
    @Override
    public List<Object[]> findProductByStock(Integer threshold) {
        return repository.findProductByStockQuantity(threshold);
    }
}
