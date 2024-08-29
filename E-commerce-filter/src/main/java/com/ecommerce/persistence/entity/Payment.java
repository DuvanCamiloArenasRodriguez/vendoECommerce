package com.ecommerce.persistence.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "payment_date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date paymentDate;

    @NotBlank
    @Column(name = "total", nullable = false)
    private Double total;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "payment_method_code")
        private PaymentMethod paymentMethod;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "customer_code_pa")
    private Customer customer;

    public Payment() {
        System.out.println(paymentDate);
    }

    public Payment(Date paymentDate, Double total) {
        this.paymentDate = paymentDate;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymentDate=" + paymentDate +
                ", total=" + total +
//                ", paymentMethod=" + paymentMethod +
//                ", customer=" + customer +
                '}';
    }
}