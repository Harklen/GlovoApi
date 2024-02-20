package ua.hillel.stolitnii.glovo.rest;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
public class Order {
    @Id
    private Long id;
    private Date date;
    private double cost;
    private List<Product> products;

    public Order() {
    }

    public Order(Long id, Date date, double cost, List<Product> products) {
        this.id = id;
        this.date = date;
        this.cost = cost;
        this.products = products;
    }

    // Геттери та сеттери

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
