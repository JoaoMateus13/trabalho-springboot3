package com.ed2.couse.config;

import com.ed2.couse.entities.Category;
import com.ed2.couse.entities.Order;
import com.ed2.couse.entities.User;
import com.ed2.couse.enums.OrderStatus;
import com.ed2.couse.repositories.CategoryRepository;
import com.ed2.couse.repositories.OrderRepository;
import com.ed2.couse.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "jm", "jms@gmail.com", "9898776756", "jms3237");
        User u2 = new User(null, "jp", "jp@gmail.com", "9898336756", "jmp3237");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2020-07-20T11:53:07Z"),OrderStatus.SHIPPED, u2);
        Order o3 = new Order(null, Instant.parse("2021-03-21T15:32:01Z"),OrderStatus.WAITING_PAYMENT, u2);

        Category c1 = new Category(null, "João Mateus");
        Category c2 = new Category(null, "João Lopes");
        Category c3 = new Category(null, "João Pedro");

        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));


        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

    }
}
