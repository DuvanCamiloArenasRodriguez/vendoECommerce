package com.ecommerce.domain.service.user;

import com.ecommerce.persistence.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User save(User user);
    boolean existsByUsername(String username);
}
