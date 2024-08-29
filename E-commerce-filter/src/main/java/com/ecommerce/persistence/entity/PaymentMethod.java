package com.ecommerce.persistence.entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "payment_method")
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "method_name", length = 50)
    private String methodName;

//    @OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.ALL)
//    private Set<Payment> payments;

    public PaymentMethod() {
//        this.payments = new HashSet<>();
    }

    public PaymentMethod(String methodName) {
        this();
        this.methodName = methodName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

//    public Set<Payment> getPayments() {
//        return payments;
//    }
//
//    public void setPayments(Set<Payment> payments) {
//        this.payments = payments;
//    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "id=" + id +
                ", methodName='" + methodName + '\'' +
                '}';
    }
}