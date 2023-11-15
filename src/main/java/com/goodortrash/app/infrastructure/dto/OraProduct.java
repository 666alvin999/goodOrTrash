package com.goodortrash.app.infrastructure.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class OraProduct {

    private String reference;
    private String name;
    private String category;
    private String brand;
    private String packing;
    private String quantity;
    private String labels;
    private String origin;
    private char nutriScore;
    private int novaScore;
    private char ecoScore;
    private String explanation;

    public static OraProductBuilder oraProduct() {
        return new OraProductBuilder();
    }

}
