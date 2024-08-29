package com.ecommerce.domain.service.office;

import com.ecommerce.domain.repository.OfficeRepository;
import com.ecommerce.persistence.entity.Office;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OfficeImpl implements IOffice {
    @Autowired
    private OfficeRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Office> findAll() {
        return (List<Office>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Office> findById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    @Override
    public Office save(Office office) {
        return repository.save(office);
    }

    @Transactional
    @Override
    public Optional<Office> update(Long id, Office office) {
        Optional<Office> getOffice = repository.findById(id);
        if (getOffice.isPresent()) {
            Office newOffice = getOffice.orElseThrow();
            newOffice.setAddress(office.getAddress());
//            newOffice.setEmployees(office.getEmployees());
            return Optional.of(repository.save(newOffice));
        }
        return getOffice;
    }

    @Transactional
    @Override
    public Optional<Office> delete(Long id) {
        Optional<Office> getOffice = repository.findById(id);
        getOffice.ifPresent(repository::delete);
        return getOffice;
    }
}
