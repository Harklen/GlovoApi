package ua.hillel.stolitnii.glovo.rest;

import java.util.Date;
import java.util.List;

public interface OrderService {
    Order findById(Long id);
    List<Order> findAll();
    void save(Order order);
    void update(Order order);
    void delete(Long id);
    OrderDto findByIdWithMapstruct(Long id);
}
