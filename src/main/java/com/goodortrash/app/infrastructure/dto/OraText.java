package com.goodortrash.app.infrastructure.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class OraText {

    private String id;
    private String text;
    private String textType;

    public static OraTextBuilder oraText() {
        return new OraTextBuilder();
    }

}
