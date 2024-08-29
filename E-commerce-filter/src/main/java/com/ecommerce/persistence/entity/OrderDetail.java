package com.ecommerce.persistence.entity;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private Integer quantity;

    @NotBlank
    @Column(name = "unit_price")
    private Integer unitPrice;

//    @Column(name = "line_number")
//    private Integer lineNumber;

//    Revisarrrrrrrrrrr
    @NotBlank
    @ManyToOne
    @JoinColumn(name = "product_id_order")
    private Product productIdOrder;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "order_id_product")
    private NOrder orderIdProduct;
//


    public OrderDetail() {
    }

    public OrderDetail(Integer quantity, Integer unitPrice) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
//        this.lineNumber = lineNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

//    public Integer getLineNumber() {
//        return lineNumber;
//    }
//
//    public void setLineNumber(Integer lineNumber) {
//        this.lineNumber = lineNumber;
//    }

    public Product getProductIdOrder() {
        return productIdOrder;
    }

    public void setProductIdOrder(Product productIdOrder) {
        this.productIdOrder = productIdOrder;
    }

    public NOrder getOrderIdProduct() {
        return orderIdProduct;
    }

    public void setOrderIdProduct(NOrder orderIdProduct) {
        this.orderIdProduct = orderIdProduct;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
//                ", lineNumber=" + lineNumber +
                ", productIdOrder=" + productIdOrder +
                ", orderIdProduct=" + orderIdProduct +
                '}';
    }
}
