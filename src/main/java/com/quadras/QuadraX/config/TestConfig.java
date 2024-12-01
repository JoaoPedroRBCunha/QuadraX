package com.quadras.QuadraX.config;

import com.quadras.QuadraX.entities.Category;
import com.quadras.QuadraX.entities.Product;
import com.quadras.QuadraX.entities.User;
import com.quadras.QuadraX.entities.Order;
import com.quadras.QuadraX.entities.enums.OrderStatus;
import com.quadras.QuadraX.repositories.CategoryRepository;
import com.quadras.QuadraX.repositories.OrderRepository;
import com.quadras.QuadraX.repositories.ProductRepository;
import com.quadras.QuadraX.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner; // Utilizado para executar a classe ao programa executar
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    // Princípios SOLID, quando um serviço depende de outro essa dependência tem que ser fraca, sendo desacoplada
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

        Category cat1 = new Category(null, "Quadra Poliesportiva");
        Category cat2 = new Category(null, "Beach Tennis");
        Category cat3 = new Category(null, "Society");

        Product p1 = new Product(null, "Racha Futebol", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product p2 = new Product(null, "Racha Basquete", "Nulla eu imperdiet purus. Maecenas ante.", 100.0, "");
        Product p3 = new Product(null, "Racha Futsal", "Nam eleifend maximus tortor, at mollis.", 100.0, "");
        Product p4 = new Product(null, "Treino Beach Tenis", "Donec aliquet odio ac rhoncus cursus.", 200.0, "");
        Product p5 = new Product(null, "Quadra Society", "Cras fringilla convallis sem vel faucibus.", 150.99, "");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
