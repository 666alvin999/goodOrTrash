package com.goodortrash.app.infrastructure.mapper;

import com.goodortrash.app.domain.bean.Product;
import com.goodortrash.app.infrastructure.dto.OraProduct;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static com.goodortrash.app.domain.bean.Product.product;

@Component
public class OraProductMapper {

    public Product mapToBusiness(OraProduct oraProduct) {
        List<String> categories = Arrays.stream(oraProduct.getCategory().split(";")).toList();
        List<String> origins = Arrays.stream(oraProduct.getOrigin().split(";")).toList();

        return new Product(
                oraProduct.getReference(),
                oraProduct.getName(),
                oraProduct.getBrand(),
                categories,
                oraProduct.getPacking(),
                origins,
                oraProduct.getEcoScore(),
                oraProduct.getExplanation(),
                oraProduct.getUrlToOpenFoodFacts()
        );
    }

    public List<Product> mapAllToBusiness(List<OraProduct> oraProducts) {
        return oraProducts.stream().map(this::mapToBusiness).toList();
    }
}
