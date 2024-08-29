package com.ecommerce.domain.service.norder;

import com.ecommerce.persistence.entity.NOrder;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface INOrder {
    List<NOrder> findAll();
    Optional<NOrder> findById(Long id);
    NOrder save(NOrder order);
    Optional<NOrder> update(Long id, NOrder order);
    Optional<NOrder> delete(Long id);
    List<Object[]> findByStatus(Long statusId);
    // Método para obtener pedidos por rango de fechas de orderDate
    List<Object[]> findOrdersByOrderDateRange(Date startDate, Date endDate);
    List<Object[]> findOrdersByEmployee(Long id);



}
