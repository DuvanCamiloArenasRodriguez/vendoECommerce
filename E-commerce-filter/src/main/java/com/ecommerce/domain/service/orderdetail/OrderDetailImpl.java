package com.ecommerce.domain.service.orderdetail;

import com.ecommerce.domain.repository.OrderDetailRepository;
import com.ecommerce.persistence.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailImpl implements IOrderDetail {

    @Autowired
    private OrderDetailRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<OrderDetail> findAll() {
        return (List<OrderDetail>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<OrderDetail> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public OrderDetail save(OrderDetail orderDetail) {
        return repository.save(orderDetail);
    }

    @Transactional
    @Override
    public Optional<OrderDetail> update(Long id, OrderDetail orderDetail) {
        Optional<OrderDetail> orderDetailOpt = repository.findById(id);
        if (orderDetailOpt.isPresent()) {
            OrderDetail orderDetailImpl = orderDetailOpt.orElseThrow();
            orderDetailImpl.setOrderIdProduct(orderDetail.getOrderIdProduct());
            orderDetailImpl.setProductIdOrder(orderDetail.getProductIdOrder());
            orderDetailImpl.setQuantity(orderDetail.getQuantity());
//            orderDetailImpl.setLineNumber(orderDetail.getLineNumber());
            orderDetailImpl.setUnitPrice(orderDetail.getUnitPrice());
            return Optional.of(repository.save(orderDetailImpl));
        }
        return orderDetailOpt;
    }

    @Transactional
    @Override
    public Optional<OrderDetail> delete(Long id) {
        Optional<OrderDetail> orderDetailOpt = repository.findById(id);
        orderDetailOpt.ifPresent(orderDetail -> {
            repository.delete(orderDetail);
        });
        return orderDetailOpt;
    }
}
