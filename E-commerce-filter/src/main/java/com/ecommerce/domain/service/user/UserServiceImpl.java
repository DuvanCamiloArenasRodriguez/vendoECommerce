package com.ecommerce.domain.service.user;

import com.ecommerce.domain.repository.RoleRepository;
import com.ecommerce.domain.repository.UserRepository;
import com.ecommerce.persistence.entity.User;
import com.ecommerce.persistence.entity.Role;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return (List<User>) repository.findAll();
    }

    @Transactional
    @Override
    public User save(User user) {

        Optional<Role> optionalRoleUser = roleRepository.findByName("ROLE_USER");
        List<Role> roles = new ArrayList<>();
        optionalRoleUser.ifPresent(roles::add);

        // desde el front debemos enviar un boolean para decir si el user tiene el rol de admin
        if (user.isAdmin()){
            Optional<Role> optionalRoleAdmin = roleRepository.findByName("ROLE_ADMIN");
            optionalRoleAdmin.ifPresent(roles::add);
        }

        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

}

