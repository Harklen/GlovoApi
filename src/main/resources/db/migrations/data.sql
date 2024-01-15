-- data.sql

CREATE TABLE IF NOT EXISTS orders (
                                      id BIGINT PRIMARY KEY,
                                      date TIMESTAMP,
                                      cost DOUBLE
);