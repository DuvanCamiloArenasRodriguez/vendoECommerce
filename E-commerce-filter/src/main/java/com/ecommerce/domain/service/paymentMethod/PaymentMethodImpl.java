package com.ecommerce.domain.service.paymentMethod;

import com.ecommerce.domain.repository.PaymentMethodRepository;
import com.ecommerce.persistence.entity.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodImpl implements IPaymentMethod {
    @Autowired
    private PaymentMethodRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<PaymentMethod> findAll() {
        return (List<PaymentMethod>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<PaymentMethod> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public PaymentMethod save(PaymentMethod paymentMethod) {
        return repository.save(paymentMethod);
    }

    @Transactional
    @Override
    public Optional<PaymentMethod> update(Long id, PaymentMethod paymentMethod) {
        Optional<PaymentMethod> getPaymentMethod = repository.findById(id);
        if (getPaymentMethod.isPresent()) {
            PaymentMethod newPaymentMethod = getPaymentMethod.orElseThrow();
            newPaymentMethod.setMethodName(paymentMethod.getMethodName());
//            newPaymentMethod.setPayments(paymentMethod.getPayments());
            return Optional.of(repository.save(newPaymentMethod));
        }
        return getPaymentMethod;
    }

    @Transactional
    @Override
    public Optional<PaymentMethod> delete(Long id) {
        Optional<PaymentMethod> getPaymentMethod = repository.findById(id);
        getPaymentMethod.ifPresent(repository::delete);
        return getPaymentMethod;
    }
}
