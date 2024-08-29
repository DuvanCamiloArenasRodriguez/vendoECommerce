package com.ecommerce.domain.service.productrange;

import com.ecommerce.domain.repository.ProductRangeRepository;
import com.ecommerce.persistence.entity.ProductRange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductRangeImpl implements IProductRange{
    @Autowired
    private ProductRangeRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<ProductRange> findAll() {
        return (List<ProductRange>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<ProductRange> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public ProductRange save(ProductRange productRange) {
        return repository.save(productRange);
    }

    @Transactional
    @Override
    public Optional<ProductRange> update(Long id, ProductRange productRange) {
        Optional<ProductRange> productRangeOpt = repository.findById(id);
        if (productRangeOpt.isPresent()) {
            ProductRange productRangeItem = productRangeOpt.orElseThrow();
            productRangeItem.setName(productRange.getName());
            productRangeItem.setDescription(productRange.getDescription());
            productRangeItem.setImage(productRange.getImage());
            return Optional.of(repository.save(productRangeItem));
        }
        return productRangeOpt;
    }

    @Transactional
    @Override
    public Optional<ProductRange> delete(Long id) {
        Optional<ProductRange> productRangeOpt = repository.findById(id);
        productRangeOpt.ifPresent(productRangeItem -> {
            repository.delete(productRangeItem);
        });
        return productRangeOpt;
    }
}
