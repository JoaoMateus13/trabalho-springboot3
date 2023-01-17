package com.ed2.couse.config;

import com.ed2.couse.entities.User;
import com.ed2.couse.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.lang.reflect.Array;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "jm", "jms@gmail.com", "9898776756", "jms3237");
        User u2 = new User(null, "jp", "jp@gmail.com", "9898336756", "jmp3237");


        userRepository.saveAll(Arrays.asList(u1,u2));

    }
}
