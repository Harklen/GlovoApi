package ua.hillel.stolitnii.glovo.rest;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
    void delete(Long id);
}
