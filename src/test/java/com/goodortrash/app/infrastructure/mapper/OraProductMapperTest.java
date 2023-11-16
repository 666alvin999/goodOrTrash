package com.goodortrash.app.infrastructure.mapper;

import com.goodortrash.app.domain.bean.Product;
import com.goodortrash.app.infrastructure.dto.OraProduct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.goodortrash.app.domain.bean.Product.product;
import static com.goodortrash.app.infrastructure.dto.OraProduct.oraProduct;
import static org.assertj.core.api.Assertions.assertThat;

class OraProductMapperTest {

    private OraProductMapper oraProductMapper;

    @BeforeEach
    public void setUp() {
        oraProductMapper = new OraProductMapper();
    }

    @Test
    public void shouldMapOraProductToBusinessProduct() {
        OraProduct oraProduct = oraProduct()
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
                .build();

        //Act
        Product outputProduct = oraProductMapper.mapToBusiness(oraProduct);

        //Assert
        Product expectedProduct = product()
                .id("0001")
                .name("Coca-Cola 33ml 6-pack")
                .categories(List.of("Drink"))
                .brand("Coca-Cola")
                .packing("plastic")
                .origins(List.of("USA"))
                .ecoScore('E')
                .explanation("ta mere le triceratops tetraplegique")
                .urlToOpenFoodFacts("xxx")
                .build();

        assertThat(outputProduct).isEqualTo(expectedProduct);
    }

    @Test
    public void shouldMapAllOraProductsToBusinessProducts() {
        List<OraProduct> oraProducts = List.of(oraProduct()
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
                .build());

        //Act
        List<Product> outputProducts = oraProductMapper.mapAllToBusiness(oraProducts);

        //Assert
        List<Product> expectedProducts = List.of(product()
                .id("0001")
                .name("Coca-Cola 33ml 6-pack")
                .categories(List.of("Drink"))
                .brand("Coca-Cola")
                .packing("plastic")
                .origins(List.of("USA"))
                .ecoScore('E')
                .explanation("ta mere le triceratops tetraplegique")
                .urlToOpenFoodFacts("xxx")
                .build());

        assertThat(outputProducts).isEqualTo(expectedProducts);
    }

}