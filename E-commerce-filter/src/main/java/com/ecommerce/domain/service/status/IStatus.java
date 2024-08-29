package com.ecommerce.domain.service.status;

import com.ecommerce.persistence.entity.Status;

import java.util.List;
import java.util.Optional;

public interface IStatus {
    List<Status> findAll();
    Optional<Status> findById(Long id);
    Status save(Status status);
    Optional<Status> update(Long id, Status status);
    Optional<Status> delete(Long id);
}
