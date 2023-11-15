package com.goodortrash.app.infrastructure.mapper;

import com.goodortrash.app.domain.bean.Product;
import com.goodortrash.app.infrastructure.dto.OraProduct;

import java.util.Arrays;
import java.util.List;

import static com.goodortrash.app.domain.bean.Product.product;

public class OraProductMapper {

    public Product mapToBusiness(OraProduct oraProduct) {
        List<String> categories = Arrays.stream(oraProduct.getCategory().split(";")).toList();
        List<String> origins = Arrays.stream(oraProduct.getOrigin().split(";")).toList();

        return product()
                .name(oraProduct.getName())
                .brand(oraProduct.getBrand())
                .categories(categories)
                .packing(oraProduct.getPacking())
                .origins(origins)
                .ecoScore(oraProduct.getEcoScore())
                .explanation(oraProduct.getExplanation())
                .novaScore(oraProduct.getNovaScore())
                .nutriScore(oraProduct.getNutriScore())
                .build();
    }

}
