package ua.hillel.stolitnii.glovo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public Order findById(Long id) {
        try {
            return orderRepository.findById(id).orElse(null);
        } catch (Exception e) {
            log.error("Error while finding order by ID: {}", id, e);
            throw e;
        }
    }

    @Override
    public List<Order> findAll() {
        try {
            return (List<Order>) orderRepository.findAll();
        } catch (Exception e) {
            log.error("Error while finding all orders", e);
            throw e;
        }
    }

    @Override
    public void save(Order order) {
        try {
            orderRepository.save(order);
        } catch (Exception e) {
            log.error("Error while saving order: {}", order, e);
            throw e;
        }
    }

    @Override
    public void update(Order order) {
        try {
            orderRepository.save(order);
        } catch (Exception e) {
            log.error("Error while updating order: {}", order, e);
            throw e;
        }
    }

    @Override
    public void delete(Long id) {
        try {
            orderRepository.delete(id);
        } catch (Exception e) {
            log.error("Error while deleting order by ID: {}", id, e);
            throw e;
        }
    }
}
