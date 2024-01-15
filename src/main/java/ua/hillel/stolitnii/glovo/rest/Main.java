package ua.hillel.stolitnii.glovo.rest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner demo(OrderRepository orderRepository) {
        return (args) -> {

            Product product1 = new Product(1L, "Product A", 50.0);
            Product product2 = new Product(2L, "Product B", 30.0);
            List<Product> products = new ArrayList<>();
            products.add(product1);
            products.add(product2);

            Order newOrder = new Order(1L, new Date(), 80.0, products);

            orderRepository.save(newOrder);


            List<Order> allOrders = orderRepository.findAll();
            System.out.println("All Orders: " + allOrders);


            Order foundOrder = orderRepository.findById(1L);
            System.out.println("Found Order: " + foundOrder);
        };
    }
}
