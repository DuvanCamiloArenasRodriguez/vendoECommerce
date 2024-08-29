package com.ecommerce.web.controller;

import com.ecommerce.domain.service.user.UserService;
import com.ecommerce.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
//@CrossOrigin(originPatterns = "*")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    private List<User> list(){
        return service.findAll();
    }

    @PostMapping
    private ResponseEntity<?> create(@Valid @RequestBody User user, BindingResult result){
        // valdation.validate(user, result);
        if (result.hasFieldErrors()) {
            return validation(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
    }

    @PostMapping("/register")
    private ResponseEntity<?> register(@Valid @RequestBody User user, BindingResult result){
        user.setAdmin(false);
        return create(user, result);
    }

    // validar con anotaciones
    private ResponseEntity<?> validation(BindingResult result) {
        Map<String, String> errors = new HashMap<>();

        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }

}
