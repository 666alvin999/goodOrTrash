package com.goodortrash.app.domain.usecase;

import com.goodortrash.app.domain.bean.Product;
import com.goodortrash.app.domain.port.ProductPort;
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
class GetProductByReferenceTest {

    private GetProductByReference getProductByReference;

    @Mock
    private ProductPort productAdapter;

    @BeforeEach
    public void setUp() {
        getProductByReference = new GetProductByReference(productAdapter);
    }

    @Test
    public void givenValidId_when_GettingMarcelDialogById_thenGetMarcelDialog() {
        //Arrange
        Product product = product()
                .name("Coca-Cola 33ml 6-pack")
                .categories(List.of("Drink"))
                .brand("Coca-Cola")
                .packing("plastic")
                .origins(List.of("USA"))
                .ecoScore('E')
                .explanation("ta mere le triceratops tetraplegique")
                .urlToOpenFoodFacts("xxx")
                .build();

        when(productAdapter.getProductByReference("0001")).thenReturn(product);

        //Act
        Product output = getProductByReference.execute("0001");

        //Assert
        assertThat(output).isEqualTo(product);
    }

}