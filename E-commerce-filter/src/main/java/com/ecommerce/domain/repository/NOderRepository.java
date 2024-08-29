package com.ecommerce.domain.repository;

import com.ecommerce.persistence.entity.NOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface NOderRepository extends CrudRepository<NOrder, Long> {
    //consultar pedido por estado
    @Query("SELECT o.id, o.orderDate, o.expectedDate, o.deliveryDate, o.customerCodeOr, o.statusCodeOr " +
            "FROM NOrder o " +
            "JOIN o.statusCodeOr s " +
            "WHERE s.id = :id")
    List<Object[]> findOrderDataByStatusId(@Param("id") Long id);

    //consultar pedido por rango de fecha
    @Query("SELECT o.id, o.orderDate, o.expectedDate, o.deliveryDate, o.customerCodeOr, o.statusCodeOr " +
            "FROM NOrder o " +
            "WHERE o.orderDate BETWEEN :startDate AND :endDate")
    List<Object[]> findOrdersByOrderDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

    //consultar empleados y sus pedidos
    @Query("SELECT o.id, o.orderDate, o.expectedDate, o.deliveryDate, o.customerCodeOr, o.statusCodeOr " +
            "FROM NOrder o " +
            "JOIN o.customerCodeOr c " +
            "JOIN o.statusCodeOr s " +
            "JOIN c.salesRep e " +
            "WHERE e.id = :id")
    List<Object[]> findOrdersByEmployee(@Param("id") Long id);

}
