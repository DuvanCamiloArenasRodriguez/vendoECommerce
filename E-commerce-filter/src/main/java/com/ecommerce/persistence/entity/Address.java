package com.ecommerce.persistence.entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "address_line1", length = 50)
    private String addressLine1;

//    Esta puede estar en blanco
    @Column(name = "address_line2", length = 50)
    private String addressLine2;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "city_code_d")
    private City city;

//    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
//    private Set<Office> offices;

//    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
//    private Set<Customer> customers;

    public Address() {
 //       this.offices = new HashSet<>();
//        this.customers = new HashSet<>();
    }

    public Address(String addressLine1, String addressLine2) {
        this();
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

//    public Set<Customer> getCustomers() {
//        return customers;
//    }
//
//    public void setCustomers(Set<Customer> customers) {
//        this.customers = customers;
//    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
//                ", city=" + city +
                '}';
    }
}
