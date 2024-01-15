package ua.hillel.stolitnii.glovo.rest;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderRepository {
    Order findById(Long id);
    List<Order> findAll();
    void save(Order order);
    void update(Order order);
    void delete(Long id);
}
