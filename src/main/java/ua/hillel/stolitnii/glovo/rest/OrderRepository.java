package ua.hillel.stolitnii.glovo.rest;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
    Order findById(Long id);
    List<Order> findAll();
    void save(Order order);
    void update(Order order);
    void delete(Long id);
}
