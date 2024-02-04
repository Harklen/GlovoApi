package ua.hillel.stolitnii.glovo.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Date;

public class OrderTest {

    @Test
    public void testGettersAndSetters() {

        Long id = 1L;
        Date date = new Date();
        double cost = 80.0;
        List<Product> products = Arrays.asList(new Product(1L, "Product A", 50.0));


        Order order = new Order();
        order.setId(id);
        order.setDate(date);
        order.setCost(cost);
        order.setProducts(products);


        assertEquals(id, order.getId());
        assertEquals(date, order.getDate());
        assertEquals(cost, order.getCost());
        assertEquals(products, order.getProducts());
    }

}
