package com.ecommerce.persistence.entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "office")
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_code_o", nullable = false)
    private Address address;

//    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
//    private Set<Employee> employees;

    public Office() {
//        this.employees = new HashSet<>();
    }

    public Office(Address address) {
        this();
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

//    public Set<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(Set<Employee> employees) {
//        this.employees = employees;
//    }

    @Override
    public String toString() {
        return "Office{" +
                "id=" + id +
//                ", address=" + address +
                '}';
    }
}
