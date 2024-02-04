package ua.hillel.stolitnii.glovo.rest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void testFindById() {

        Order order = new Order(1L, new Date(), 80.0, Collections.emptyList());
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));


        Optional<Order> result = orderRepository.findById(1L);


        assertTrue(result.isPresent());
        assertEquals(order, result.get());
    }

    @Test
    public void testFindAll() {

        List<Order> orders = Arrays.asList(
                new Order(1L, new Date(), 80.0, Collections.emptyList()),
                new Order(2L, new Date(), 120.0, Collections.emptyList())
        );
        when(orderRepository.findAll()).thenReturn(orders);


        List<Order> result = orderRepository.findAll();


        assertEquals(2, result.size());
        assertEquals(orders, result);
    }


}
