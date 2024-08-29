package com.ecommerce.persistence.entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "name", length = 30, nullable = false)
    private String name;

//    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
//   private Set<Address> addresses;

//    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
//    private Set<Customer> customers;

    public City() {
//      this.addresses = new HashSet<>();
//        this.customers = new HashSet<>();
    }

    public City(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
