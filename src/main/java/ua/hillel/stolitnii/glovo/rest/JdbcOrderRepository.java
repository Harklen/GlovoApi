package ua.hillel.stolitnii.glovo.rest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class JdbcOrderRepository implements OrderRepository {

    private JdbcTemplate jdbcTemplate;

    public JdbcOrderRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Order findById(Long id) {
        String sql = "SELECT * FROM orders WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new OrderRowMapper());
    }

    @Override
    public List<Order> findAll() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, new OrderRowMapper());
    }

    @Override
    public void save(Order order) {
        String sql = "INSERT INTO orders (id, date, cost) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, order.getId(), new Timestamp(order.getDate().getTime()), order.getCost());
    }

    @Override
    public void update(Order order) {
        String sql = "UPDATE orders SET date = ?, cost = ? WHERE id = ?";
        jdbcTemplate.update(sql, new Timestamp(order.getDate().getTime()), order.getCost(), order.getId());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM orders WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    private static class OrderRowMapper implements RowMapper<Order> {
        @Override
        public Order mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            Long id = resultSet.getLong("id");
            Timestamp date = resultSet.getTimestamp("date");
            double cost = resultSet.getDouble("cost");
            return new Order(id, new java.util.Date(date.getTime()), cost, null); // Врахуйте обробку продуктів
        }
    }
}
