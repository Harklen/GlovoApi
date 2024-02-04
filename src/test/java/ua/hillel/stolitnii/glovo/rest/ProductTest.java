package ua.hillel.stolitnii.glovo.rest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ProductTest {

    @Test
    public void testGettersAndSetters() {
        Long id = 1L;
        String name = "Product A";
        double cost = 50.0;

        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setCost(cost);

        assertEquals(id, product.getId());
        assertEquals(name, product.getName());
        assertEquals(cost, product.getCost());
    }

}

