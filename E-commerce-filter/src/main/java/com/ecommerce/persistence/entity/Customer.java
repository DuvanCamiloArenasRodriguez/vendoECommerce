package com.ecommerce.persistence.entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "first_name", length = 50)
    private String firstName;

    @NotBlank
    @Column(name = "last_name1", length = 30)
    private String lastName1;

    @Column(name = "last_name2", length = 30)
    private String lastName2;

    @NotBlank
    @Column(name = "email", length = 50)
    private String email;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "city_code_c")
    private City city;

    @NotBlank
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_code_c")
    private Address address;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "sales_rep_employee_code")
    private Employee salesRep;

//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private Set<Payment> payments;

    public Customer() {
//        this.payments = new HashSet<>();
    }

    public Customer(String firstName, String lastName1, String lastName2, String email) {
        this();
        this.firstName = firstName;
        this.lastName1 = lastName1;
        this.lastName2 = lastName2;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName1() {
        return lastName1;
    }

    public void setLastName1(String lastName1) {
        this.lastName1 = lastName1;
    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Employee getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(Employee salesRep) {
        this.salesRep = salesRep;
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
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName1='" + lastName1 + '\'' +
                ", lastName2='" + lastName2 + '\'' +
                ", email='" + email + '\'' +
                ", city=" + city +
//                ", address=" + address +
//                ", salesRep=" + salesRep +
                '}';
    }
}
