package com.goodortrash.app.infrastructure.dao;

import com.goodortrash.app.infrastructure.dto.OraText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;


@Repository
public class OraTextDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private final String BY_TEXT_TYPE = "SELECT * FROM TEXT WHERE TEXT_TYPE LIKE :textType;";

    public OraTextDao() {

    }

    public OraTextDao(@Qualifier(value = "datasource") DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<OraText> getTextByTextType(String textType) {
        Map<String, String> parameters = Map.of("textType", textType);

        return jdbcTemplate.query(BY_TEXT_TYPE, parameters, new BeanPropertyRowMapper<>(OraText.class));
    }

}
