package com.ecommerce.domain.service.user;

import com.ecommerce.domain.repository.UserRepository;
import com.ecommerce.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    // inyectar para acceder al método findByUsername
    @Autowired
    private UserRepository repository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // En Optional<User>, User es propio de spring
        Optional<User> userOptional  = repository.findByUsername(username);
        if(userOptional.isEmpty()){
            throw new UsernameNotFoundException(String.format("El usuario %s no existe", username));
        }

        User user = userOptional.orElseThrow();

        /*
            Obtener los roles del usuario
            la clase UserDetailsService se le debe pasar una lista de roles, pero deben ser del tipo GrantedAuthority
        */
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        // Se debe retornar un tipo UserDetails, esta clase User implemente la interface
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
    }
}

