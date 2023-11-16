package com.goodortrash.app.presentation.mapper;

import com.goodortrash.app.domain.bean.Product;
import com.goodortrash.app.presentation.dto.ProductView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.goodortrash.app.domain.bean.Product.product;
import static com.goodortrash.app.presentation.dto.ProductView.productView;
import static org.assertj.core.api.Assertions.assertThat;

class ProductViewMapperTest {

    private ProductViewMapper productViewMapper;

    @BeforeEach
    public void setUp() {
        productViewMapper = new ProductViewMapper();
    }

    @Test
    public void shouldReturnProductViewModel() {
        //Arrange
        Product product = product()
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

        //Act
        ProductView output = productViewMapper.mapToViewModel(product);

        //Assert
        ProductView expectedOutput = productView()
                .id("0001")
                .name("Coca-Cola 33ml 6-pack")
                .categories(List.of("Drink"))
                .brand("Coca-Cola")
                .packing("plastic")
                .origins(List.of("USA"))
                .isEco(false)
                .explanation("ta mere le triceratops tetraplegique")
                .urlToOpenFoodFacts("xxx")
                .build();

        assertThat(output).isEqualTo(expectedOutput);
    }

}