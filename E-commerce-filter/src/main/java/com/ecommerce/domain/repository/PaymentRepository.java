package com.ecommerce.domain.repository;

import com.ecommerce.persistence.entity.Payment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
    // FILTRO PAGO POR CLIENTE
    @Query("SELECT p.id, p.total, p.paymentDate, p.paymentMethod, p.customer " +
            "FROM Payment p " +
            "JOIN p.customer c " +
            "JOIN p.paymentMethod pm " +
            "WHERE c.id = :id")
    List<Object[]> findPaymentsByCustomer(@Param("id") Long id);


    // FILTRO PAGO POR METODO DE PAGO
    @Query("SELECT p.id, p.total, p.paymentDate, p.paymentMethod, p.customer " +
            "FROM Payment p " +
            "JOIN p.customer c " +
            "JOIN p.paymentMethod pm " +
            "WHERE p.paymentMethod.id = :id")
    List<Object[]> findPaymentsByPaymentMethod(@Param("id") Long id);
}
