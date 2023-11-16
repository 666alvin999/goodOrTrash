package com.goodortrash.app.infrastructure.adapter;

import com.goodortrash.app.domain.bean.Product;
import com.goodortrash.app.infrastructure.dao.OraProductDao;
import com.goodortrash.app.infrastructure.dto.OraProduct;
import com.goodortrash.app.infrastructure.mapper.OraProductMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static com.goodortrash.app.domain.bean.Product.product;
import static com.goodortrash.app.infrastructure.dto.OraProduct.oraProduct;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OraProductsAdapterTest {

    private OraProductsAdapter oraProductsAdapter;

    @Mock
    private OraProductDao oraProductDao;

    @Mock
    private OraProductMapper oraProductMapper;

    @BeforeEach
    public void setUp() {
        oraProductsAdapter = new OraProductsAdapter(oraProductDao, oraProductMapper);
    }

    @Test
    public void givenValidReference_whenGettingProductByReference_thenGetProduct() {
        //Arrange
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

        when(oraProductDao.getProductByReference("0001")).thenReturn(Optional.of(oraProduct));
        when(oraProductMapper.mapToBusiness(oraProduct)).thenReturn(product);

        //Act
        Product outputProduct = oraProductsAdapter.getProductByReference("0001");

        //Assert
        assertThat(outputProduct).isEqualTo(product);
    }
    
    @Test
    public void givenInvalidReference_whenGettingProductByReference_thenGetNull() {
        //Arrange
        when(oraProductDao.getProductByReference("0002")).thenReturn(Optional.empty());

        //Act
        Product output = oraProductsAdapter.getProductByReference("0002");
        
        //Assert
        assertThat(output).isNull();
    }

    @Test
    public void shouldReturnAllProducts() {
        //Arrange
        List<OraProduct> oraProducts = List.of(
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

        List<Product> products = List.of(product()
                .name("Coca-Cola 33ml 6-pack")
                .categories(List.of("Drink"))
                .brand("Coca-Cola")
                .packing("plastic")
                .origins(List.of("USA"))
                .ecoScore('E')
                .explanation("ta mere le triceratops tetraplegique")
                .urlToOpenFoodFacts("xxx")
                .build()
        );

        when(oraProductDao.getAllProducts()).thenReturn(oraProducts);
        when(oraProductMapper.mapAllToBusiness(oraProducts)).thenReturn(products);

        //Act
        List<Product> outputProducts = oraProductsAdapter.getAllProducts();

        //Assert
        assertThat(outputProducts).isEqualTo(products);
    }

}