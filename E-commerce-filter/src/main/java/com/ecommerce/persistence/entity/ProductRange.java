package com.ecommerce.persistence.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_ranges")
public class ProductRange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;
    private String image;

//    @OneToMany(mappedBy = "rangeCode", cascade = CascadeType.ALL, orphanRemoval = true)
//    @JsonManagedReference
//    private List<Product> products = new ArrayList<>();


    public ProductRange() {
//        this.products = new ArrayList<>();
    }

    public ProductRange(String image, String description, String name) {
        this.image = image;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

//    public List<Product> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }

    @Override
    public String toString() {
        return "ProductRange{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
//                ", products=" + products +
                '}';
    }
}

