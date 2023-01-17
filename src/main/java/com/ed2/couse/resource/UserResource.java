package com.ed2.couse.resource;

import com.ed2.couse.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")

public class UserResource {
    @GetMapping
    public ResponseEntity<User> findAll() {
        User aluno = new User(1L, "Jão", "joao@gmail.com", "98987854942", "JMS3237");
        return ResponseEntity.ok().body(aluno);
    }
}
