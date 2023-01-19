package com.ed2.couse.config;

import com.ed2.couse.entities.Category;
import com.ed2.couse.entities.Order;
import com.ed2.couse.entities.Product;
import com.ed2.couse.entities.User;
import com.ed2.couse.enums.OrderStatus;
import com.ed2.couse.repositories.CategoryRepository;
import com.ed2.couse.repositories.OrderRepository;
import com.ed2.couse.repositories.ProductRepository;
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
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "jm", "jms@gmail.com", "9898776756", "jms3237");
        User u2 = new User(null, "jp", "jp@gmail.com", "9898336756", "jmp3237");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2020-07-20T11:53:07Z"),OrderStatus.SHIPPED, u2);
        Order o3 = new Order(null, Instant.parse("2021-03-21T15:32:01Z"),OrderStatus.WAITING_PAYMENT, u2);

        Category c1 = new Category(null, "Electronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

       // Product p1 = new Product(null, "carro", "é feio", 2600.0, "www.nãoquerosaber.com");
        Product p1 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product p4 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
        Product p5 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");

        categoryRepository.saveAll(Arrays.asList(c1,c2,c3));

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategories().add(c2);
        p2.getCategories().add(c1);
        p2.getCategories().add(c3);
        p3.getCategories().add(c3);
        p4.getCategories().add(c3);
        p5.getCategories().add(c2);


        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));



        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

    }
}
