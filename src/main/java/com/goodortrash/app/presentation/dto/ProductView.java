package com.goodortrash.app.presentation.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record ProductView(String name, String brand, List<String> categories, String packing, List<String> origins, boolean isEco, String explanation, String urlToOpenFoodFacts) {

    public static ProductViewBuilder productView() {
        return new ProductViewBuilder();
    }

}
