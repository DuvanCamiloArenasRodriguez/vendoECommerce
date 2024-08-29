package com.ecommerce.domain.service.status;

import com.ecommerce.domain.repository.StatusRepository;
import com.ecommerce.persistence.entity.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StatusImpl implements IStatus {
    @Autowired
    private StatusRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Status> findAll() {
        return (List<Status>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Status> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Status save(Status status) {
        return repository.save(status);
    }

    @Transactional
    @Override
    public Optional<Status> update(Long id, Status status) {
        Optional<Status> statusOpt = repository.findById(id);
        if (statusOpt.isPresent()) {
            Status statusItem = statusOpt.orElseThrow();
            statusItem.setStatusName(status.getStatusName());
            return Optional.of(repository.save(statusItem));
        }
        return statusOpt;
    }

    @Transactional
    @Override
    public Optional<Status> delete(Long id) {
        Optional<Status> statusOpt = repository.findById(id);
        statusOpt.ifPresent(status -> {
            repository.delete(status);
        });
        return statusOpt;
    }
}
