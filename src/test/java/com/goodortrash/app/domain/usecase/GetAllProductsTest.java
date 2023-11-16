package com.goodortrash.app.domain.usecase;

import com.goodortrash.app.domain.bean.Product;
import com.goodortrash.app.domain.port.ProductPort;
import com.goodortrash.app.presentation.port.GetAllProductsPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.goodortrash.app.domain.bean.Product.product;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetAllProductsTest {

    private GetAllProducts getAllProducts;

    @Mock
    private ProductPort productAdapter;

    @BeforeEach
    public void setUp() {
        getAllProducts = new GetAllProducts(productAdapter);
    }

    @Test
    public void givenValidId_when_GettingMarcelDialogById_thenGetMarcelDialog() {
        //Arrange
        List<Product> products = List.of(product()
                .name("Coca-Cola 33ml 6-pack")
                .categories(List.of("Drink"))
                .brand("Coca-Cola")
                .packing("plastic")
                .origins(List.of("USA"))
                .ecoScore('E')
                .explanation("ta mere le triceratops tetraplegique")
                .urlToOpenFoodFacts("xxx")
                .build());

        when(productAdapter.getAllProducts()).thenReturn(products);

        //Act
        List<Product> output = getAllProducts.execute();

        //Assert
        assertThat(output).isEqualTo(products);
    }

}