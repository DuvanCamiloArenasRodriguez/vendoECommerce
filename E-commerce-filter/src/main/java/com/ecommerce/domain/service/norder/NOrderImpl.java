package com.ecommerce.domain.service.norder;

import com.ecommerce.domain.repository.NOderRepository;
import com.ecommerce.persistence.entity.NOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NOrderImpl implements INOrder {
    @Autowired
    private NOderRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<NOrder> findAll() {
        return (List<NOrder>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<NOrder> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public NOrder save(NOrder order) {
        return repository.save(order);
    }

    @Transactional
    @Override
    public Optional<NOrder> update(Long id, NOrder nOrder) {
        Optional<NOrder> nOrderOpt = repository.findById(id);
        if (nOrderOpt.isPresent()) {
            NOrder nOrderImpl = nOrderOpt.orElseThrow();
            nOrderImpl.setOrderDate(nOrder.getOrderDate());
            nOrderImpl.setDeliveryDate(nOrder.getDeliveryDate());
            nOrderImpl.setExpectedDate(nOrder.getExpectedDate());
            nOrderImpl.setComment(nOrder.getComment());
//            nOrderImpl.setCustomerCodeOr(nOrder.getCustomerCodeOr());
            nOrderImpl.setStatusCodeOr(nOrder.getStatusCodeOr());
            return Optional.of(repository.save(nOrderImpl));

        }
        return nOrderOpt;
    }

    @Transactional
    @Override
    public Optional<NOrder> delete(Long id) {
        Optional<NOrder> nOrderOpt = repository.findById(id);
        nOrderOpt.ifPresent(nOrder -> {
            repository.delete(nOrder);
        });
        return nOrderOpt;
    }

    // obtener pedido por rango de fecha
    @Transactional(readOnly = true)
    @Override
    public List<Object[]> findOrdersByOrderDateRange(Date startDate, Date endDate) {
        return repository.findOrdersByOrderDateRange(startDate, endDate);
    }

    // Obtener pedidos por estados
    @Transactional(readOnly = true)
    @Override
    public List<Object[]> findByStatus(Long statusId) {
        return repository.findOrderDataByStatusId(statusId);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Object[]> findOrdersByEmployee(Long id) {
        return repository.findOrdersByEmployee(id);
    }
}
