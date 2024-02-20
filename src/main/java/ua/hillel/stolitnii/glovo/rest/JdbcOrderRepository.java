package ua.hillel.stolitnii.glovo.rest;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
public class JdbcOrderRepository implements OrderRepository {

    private static final Logger log = LoggerFactory.getLogger(JdbcOrderRepository.class);

    private final JdbcTemplate jdbcTemplate;

    public JdbcOrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Order findById(Long id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, new OrderRowMapper());
        } catch (Exception e) {
            log.error("Error while finding order by ID: {}", id, e);
            throw e;
        }
    }

    @Override
    public List<Order> findAll() {
        String sql = "SELECT * FROM orders";
        try {
            return jdbcTemplate.query(sql, new OrderRowMapper());
        } catch (Exception e) {
            log.error("Error while finding all orders", e);
            throw e;
        }
    }

    @Override
    public void save(Order order) {
        String sql = "INSERT INTO orders (id, date, cost) VALUES (?, ?, ?)";
        try {
            jdbcTemplate.update(sql, order.getId(), new Timestamp(order.getDate().getTime()), order.getCost());
        } catch (Exception e) {
            log.error("Error while saving order: {}", order, e);
            throw e;
        }
    }

    @Override
    public void update(Order order) {
        String sql = "UPDATE orders SET date = ?, cost = ? WHERE id = ?";
        try {
            jdbcTemplate.update(sql, new Timestamp(order.getDate().getTime()), order.getCost(), order.getId());
        } catch (Exception e) {
            log.error("Error while updating order: {}", order, e);
            throw e;
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM orders WHERE id = ?";
        try {
            jdbcTemplate.update(sql, id);
        } catch (Exception e) {
            log.error("Error while deleting order by ID: {}", id, e);
            throw e;
        }
    }

    private static class OrderRowMapper implements RowMapper<Order> {
        @Override
        public Order mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            try {
                Long id = resultSet.getLong("id");
                Timestamp date = resultSet.getTimestamp("date");
                double cost = resultSet.getDouble("cost");
                return new Order(id, new java.util.Date(date.getTime()), cost, null);
            } catch (Exception e) {
                log.error("Error while mapping order from ResultSet", e);
                throw e;
            }
        }
    }
}
