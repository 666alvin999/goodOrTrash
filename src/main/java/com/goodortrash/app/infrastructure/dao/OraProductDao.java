package com.goodortrash.app.infrastructure.dao;

import com.goodortrash.app.infrastructure.dto.OraProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class OraProductDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private final String BY_REFERENCE = "SELECT * FROM PRODUCTS WHERE REFERENCE = :reference;";
    private final String ALL_PRODUCTS = "SELECT * FROM PRODUCTS;";

    public OraProductDao() {

    }

    public OraProductDao(@Qualifier(value = "dataSource") DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<OraProduct> getAllProducts() {
        return jdbcTemplate.query(ALL_PRODUCTS, new BeanPropertyRowMapper<>(OraProduct.class));
    }

    public Optional<OraProduct> getProductByReference(String reference) {
        Map<String, String> parameters = Map.of("reference", reference);

        return Optional.of(jdbcTemplate.query(BY_REFERENCE, parameters, new BeanPropertyRowMapper<>(OraProduct.class)).get(0));
    }

}
