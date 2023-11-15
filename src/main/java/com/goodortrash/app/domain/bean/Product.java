package com.goodortrash.app.domain.bean;

import lombok.Builder;
import lombok.EqualsAndHashCode;

import java.util.List;

@Builder
public record Product(String name, String brand, List<String> categories, String packing, List<String> origins, char ecoScore, String explanation, int novaScore, char nutriScore) {

    public static ProductBuilder product() {
        return new ProductBuilder();
    }

}
