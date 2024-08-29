package com.ecommerce.domain.service.orderdetail;

import com.ecommerce.persistence.entity.OrderDetail;

import java.util.List;
import java.util.Optional;

public interface IOrderDetail {
    List<OrderDetail> findAll();
    Optional<OrderDetail> findById(Long id);
    OrderDetail save(OrderDetail orderDetail);
    Optional<OrderDetail> update(Long id, OrderDetail orderDetail);
    Optional<OrderDetail> delete(Long id);
}
