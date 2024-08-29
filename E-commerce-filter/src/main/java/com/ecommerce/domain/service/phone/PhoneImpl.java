package com.ecommerce.domain.service.phone;

import com.ecommerce.domain.repository.PhoneRepository;
import com.ecommerce.persistence.entity.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneImpl implements IPhone{

    @Autowired
    private PhoneRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Phone> findAll() {
        return (List<Phone>) repository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Phone> findById(Long id) {
        return repository.findByOffice(id);
    }

    @Transactional
    @Override
    public Phone save(Phone phone) {
        return repository.save(phone);
    }

    @Transactional
    @Override
    public Optional<Phone> update(Long id, Phone phone) {
        Optional<Phone> phoneOpt = findById(id);
        if (phoneOpt.isPresent()) {
            Phone phoneImpl = phoneOpt.orElseThrow();
            phoneImpl.setNumber(phone.getNumber());
            phoneImpl.setCustomerCodePh(phone.getCustomerCodePh());
            phoneImpl.setOfficeCodePh(phone.getOfficeCodePh());
            return Optional.of(repository.save(phoneImpl));
        }
        return phoneOpt;
    }

    @Transactional
    @Override
    public Optional<Phone> delete(Long id) {
        Optional<Phone> phoneOpt = findById(id);
        phoneOpt.ifPresent(phone -> {
            repository.delete(phone);
        });
        return phoneOpt;
    }
}
