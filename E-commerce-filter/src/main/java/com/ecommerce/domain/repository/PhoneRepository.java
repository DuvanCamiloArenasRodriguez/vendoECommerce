package com.ecommerce.domain.repository;

import com.ecommerce.persistence.entity.Phone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PhoneRepository extends CrudRepository<Phone, Long> {
    @Query("SELECT t FROM Phone t WHERE t.officeCodePh.id =?1")
    Optional<Phone> findByOffice(Long idOffice);
}
