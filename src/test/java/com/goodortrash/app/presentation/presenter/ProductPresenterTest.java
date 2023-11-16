package com.goodortrash.app.presentation.presenter;

import com.goodortrash.app.domain.bean.Product;
import com.goodortrash.app.presentation.dto.ProductView;
import com.goodortrash.app.presentation.mapper.ProductViewMapper;
import com.goodortrash.app.presentation.presenter.ProductPresenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.goodortrash.app.domain.bean.Product.product;
import static com.goodortrash.app.presentation.dto.ProductView.productView;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.util.StringUtils.trimAllWhitespace;

@ExtendWith(MockitoExtension.class)
class ProductPresenterTest {

    private ProductPresenter productPresenter;

    @Mock
    private ProductViewMapper productViewMapper;

    @BeforeEach
    public void setUp() {
        productPresenter = new ProductPresenter(productViewMapper);
    }

    @Test
    public void shouldPresentProductInJson() {
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

        ProductView productView = productView()
                .id("0001")
                .name("Coca-Cola33ml6-pack")
                .brand("Coca-Cola")
                .categories(List.of("Drink"))
                .packing("plastic")
                .origins(List.of("USA"))
                .isEco(false)
                .explanation("test")
                .urlToOpenFoodFacts("xxx")
                .build();

        when(productViewMapper.mapToViewModel(product)).thenReturn(productView);

        //Act
        ResponseEntity<String> output = productPresenter.present(product);

        //Assert
        String expectedOutput = trimAllWhitespace("""
                {
                    "id":"0001",
                    "name":"Coca-Cola33ml6-pack",
                    "brand":"Coca-Cola",
                    "categories": [
                        "Drink"
                    ],
                    "packing":"plastic",
                    "origins": [
                        "USA"
                    ],
                    "isEco":false,
                    "explanation":"test",
                    "urlToOpenFoodFacts":"xxx"
                }""");

        assertThat(output).isEqualTo(ResponseEntity.ok(expectedOutput));
    }

}