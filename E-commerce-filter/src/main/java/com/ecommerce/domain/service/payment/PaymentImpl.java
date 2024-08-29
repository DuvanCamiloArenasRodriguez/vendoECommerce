package com.ecommerce.domain.service.payment;

import com.ecommerce.domain.repository.PaymentRepository;
import com.ecommerce.persistence.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentImpl implements IPayment {
    @Autowired
    private PaymentRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Payment> findAll() {
        return (List<Payment>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Payment> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Payment save(Payment payment) {
        return repository.save(payment);
    }

    @Transactional
    @Override
    public Optional<Payment> update(Long id, Payment payment) {
        Optional<Payment> getPayment = repository.findById(id);
        if (getPayment.isPresent()) {
            Payment newPayment = getPayment.orElseThrow();
            newPayment.setPaymentDate(payment.getPaymentDate());
            newPayment.setTotal(payment.getTotal());
            newPayment.setPaymentMethod(payment.getPaymentMethod());
            newPayment.setCustomer(payment.getCustomer());
            return Optional.of(repository.save(newPayment));
        }
        return getPayment;
    }

    @Transactional
    @Override
    public Optional<Payment> delete(Long id) {
        Optional<Payment> getPayment = repository.findById(id);
        getPayment.ifPresent(repository::delete);
        return getPayment;
    }

    //PAGO POR CLIENTE
    @Transactional(readOnly = true)
    @Override
    public List<Object[]> findPaymentsByCustomer(Long id) {
        return repository.findPaymentsByCustomer(id);
    }

    //PAGO POR METODO DE PAGO
    @Transactional(readOnly = true)
    @Override
    public List<Object[]> findPaymentsByPaymentMethod(Long id) {
        return repository.findPaymentsByPaymentMethod(id);
    }
}