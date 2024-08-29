package com.ecommerce.domain.repository;

import com.ecommerce.persistence.entity.OrderDetail;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailRepository extends CrudRepository<OrderDetail, Long> {

}
