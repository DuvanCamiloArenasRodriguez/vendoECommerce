package com.ecommerce.persistence.entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "phones")
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private Integer number;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "customer_code_ph")
    private Customer customerCodePh;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "office_code_ph")
    private Office officeCodePh;

    public Phone() {
    }

    public Phone(Integer number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Customer getCustomerCodePh() {
        return customerCodePh;
    }

    public void setCustomerCodePh(Customer customerCodePh) {
        this.customerCodePh = customerCodePh;
    }

    public Office getOfficeCodePh() {
        return officeCodePh;
    }

    public void setOfficeCodePh(Office officeCodePh) {
        this.officeCodePh = officeCodePh;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", number=" + number +
                '}';
    }
}
