package com.ecommerce.persistence.entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @NotBlank
    @Column(name = "last_name1", length = 50, nullable = false)
    private String lastName1;

    @Column(name = "last_name2", length = 50)
    private String lastName2;

    @NotBlank
    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "office_code")
        private Office office;

//    @OneToMany(mappedBy = "salesRep", cascade = CascadeType.ALL)
//    private Set<Customer> customers;

    public Employee() {
//        this.customers = new HashSet<>();
    }

    public Employee(String firstName, String lastName1, String lastName2, String email) {
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

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

//    public Set<Customer> getCustomers() {
//        return customers;
//    }
//
//    public void setCustomers(Set<Customer> customers) {
//        this.customers = customers;
//    }

    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName1='" + lastName1 + '\'' +
                ", lastName2='" + lastName2 + '\'' +
                ", email='" + email + '\'' +
//                ", office=" + office +
                '}';
    }

}