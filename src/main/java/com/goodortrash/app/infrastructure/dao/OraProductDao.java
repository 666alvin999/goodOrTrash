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

@Repository
public class OraProductDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private final String BY_REFERENCE = "SELECT * FROM PRODUCTS WHERE REFERENCE = :reference;";

    public OraProductDao() {

    }

    public OraProductDao(@Qualifier(value = "dataSource") DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<OraProduct> getProductByReference(String reference) {
        Map<String, String> parameters = Map.of("reference", reference);

        return jdbcTemplate.query(BY_REFERENCE, parameters, new BeanPropertyRowMapper<>(OraProduct.class));
    }

}
