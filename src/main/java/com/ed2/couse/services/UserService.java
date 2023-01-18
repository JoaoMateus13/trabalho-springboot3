package com.ed2.couse.services;

import com.ed2.couse.entities.User;
import com.ed2.couse.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    @GetMapping
    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }

}
