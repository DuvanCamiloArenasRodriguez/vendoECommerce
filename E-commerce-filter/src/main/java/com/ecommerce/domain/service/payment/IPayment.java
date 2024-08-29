package com.ecommerce.domain.service.payment;

import com.ecommerce.persistence.entity.Payment;
import java.util.List;
import java.util.Optional;

public interface IPayment {
    List<Payment> findAll();
    Optional<Payment> findById(Long id);
    Payment save(Payment payment);
    Optional<Payment> update(Long id, Payment payment);
    Optional<Payment> delete(Long id);
    //pago por cliente
    List<Object[]> findPaymentsByCustomer(Long id);

    //pago por metodo de pago
    List<Object[]> findPaymentsByPaymentMethod(Long id);
}
