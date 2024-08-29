package com.ecommerce.domain.repository;

import com.ecommerce.persistence.entity.PaymentMethod;
import org.springframework.data.repository.CrudRepository;

public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, Long> {
}