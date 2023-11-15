package com.goodortrash.app.infrastructure.dao;

import com.goodortrash.app.infrastructure.dto.OraText;
import com.goodortrash.utils.BasicDatabaseExtension;
import com.goodortrash.utils.EzDatabase;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.nio.file.Paths;
import java.util.HashMap;

import static java.nio.file.Files.readAllBytes;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.ReflectionTestUtils.setField;
import static com.goodortrash.app.infrastructure.dto.OraText.oraText;

@ExtendWith(BasicDatabaseExtension.class)
class OraTextDaoTest {

    private OraTextDao oraTextDao;

    @EzDatabase
    private NamedParameterJdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setUp() {
        oraTextDao = new OraTextDao();
        setField(oraTextDao, "jdbcTemplate", jdbcTemplate);

        initTables();
    }

    @Test
    public void shouldReturnTextById() {
        //Act
        OraText outputOraText = oraTextDao.getTextById("0001").get(0);

        //Assert
        OraText expectedOutput = oraText()
                .id("0001")
                .text("PAPA BAISE TES MORTS")
                .moral("BAD")
                .build();

        assertThat(outputOraText).isEqualTo(expectedOutput);
    }

    @SneakyThrows
    private void initTables() {
        jdbcTemplate.update(
                new String(readAllBytes(Paths.get("src/test/resources/initText.sql"))),
                new HashMap<>()
        );
    }

}