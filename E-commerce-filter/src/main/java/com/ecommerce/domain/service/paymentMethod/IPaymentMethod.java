package com.ecommerce.domain.service.paymentMethod;

import com.ecommerce.persistence.entity.PaymentMethod;
import java.util.List;
import java.util.Optional;

public interface IPaymentMethod {
    List<PaymentMethod> findAll();
    Optional<PaymentMethod> findById(Long id);
    PaymentMethod save(PaymentMethod paymentMethod);
    Optional<PaymentMethod> update(Long id, PaymentMethod paymentMethod);
    Optional<PaymentMethod> delete(Long id);
}