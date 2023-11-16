package com.goodortrash.app.infrastructure.dao;

import com.goodortrash.app.infrastructure.dto.OraProduct;
import com.goodortrash.utils.BasicDatabaseExtension;
import com.goodortrash.utils.EzDatabase;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static com.goodortrash.app.infrastructure.dto.OraProduct.oraProduct;
import static java.nio.file.Files.readAllBytes;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.ReflectionTestUtils.setField;

@ExtendWith(BasicDatabaseExtension.class)
class OraProductDaoTest {

    private OraProductDao oraProductDao;

    @EzDatabase
    private NamedParameterJdbcTemplate jdbcTemplate;

    @BeforeEach
    public void setUp() {
        oraProductDao = new OraProductDao();
        setField(oraProductDao, "jdbcTemplate", jdbcTemplate);

        initTables();
    }

    @Test
    public void shouldReturnOraProductByReference() {
        //Act
        Optional<OraProduct> outputOraProduct = oraProductDao.getProductByReference("0001");

        //Assert
        Optional<OraProduct> expectedOraProduct = Optional.of(
                oraProduct()
                        .reference("0001")
                        .name("Coca-Cola 33ml 6-pack")
                        .category("Drink")
                        .brand("Coca-Cola")
                        .packing("plastic")
                        .quantity("6 cans")
                        .labels("Good but bad")
                        .origin("USA")
                        .nutriScore('D')
                        .novaScore(4)
                        .ecoScore('E')
                        .explanation("ta mere le triceratops tetraplegique")
                        .urlToOpenFoodFacts("xxx")
                        .build()
        );

        assertThat(outputOraProduct).isEqualTo(expectedOraProduct);
    }

    @Test
    public void shouldReturnAllOraProducts() {
        //Act
        List<OraProduct> outputOraProduct = oraProductDao.getAllProducts();

        //Assert
        List<OraProduct> expectedOraProducts = List.of(
                oraProduct()
                        .reference("0001")
                        .name("Coca-Cola 33ml 6-pack")
                        .category("Drink")
                        .brand("Coca-Cola")
                        .packing("plastic")
                        .quantity("6 cans")
                        .labels("Good but bad")
                        .origin("USA")
                        .nutriScore('D')
                        .novaScore(4)
                        .ecoScore('E')
                        .explanation("ta mere le triceratops tetraplegique")
                        .urlToOpenFoodFacts("xxx")
                        .build()
        );

        assertThat(outputOraProduct).isEqualTo(expectedOraProducts);
    }

    @SneakyThrows
    private void initTables() {
        jdbcTemplate.update(
                new String(readAllBytes(Paths.get("src/test/resources/initProducts.sql"))),
                new HashMap<>()
        );
    }

}