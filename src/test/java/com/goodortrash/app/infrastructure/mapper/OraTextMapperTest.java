package com.goodortrash.app.infrastructure.mapper;

import com.goodortrash.app.domain.bean.MarcelDialog;
import com.goodortrash.app.domain.bean.Product;
import com.goodortrash.app.infrastructure.dto.OraProduct;
import com.goodortrash.app.infrastructure.dto.OraText;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.goodortrash.app.domain.bean.MarcelDialog.marcelDialog;
import static com.goodortrash.app.domain.bean.Product.product;
import static com.goodortrash.app.infrastructure.dto.OraProduct.oraProduct;
import static com.goodortrash.app.infrastructure.dto.OraText.oraText;
import static org.assertj.core.api.Assertions.assertThat;

class OraTextMapperTest {

    private OraTextMapper oraTextMapper;

    @BeforeEach
    public void setUp() {
        oraTextMapper = new OraTextMapper();
    }

    @Test
    public void shouldMapOraTextToBusinessText() {
        OraText oraText = oraText()
                .id("0001")
                .text("PAPA BAISE TES MORTS")
                .moral("BAD")
                .build();

        //Act
        MarcelDialog outputDialog = oraTextMapper.mapToBusiness(oraText);

        //Assert
        MarcelDialog expectedDialog = marcelDialog()
                .text("PAPA BAISE TES MORTS")
                .moral("BAD")
                .build();

        assertThat(outputDialog).isEqualTo(expectedDialog);
    }

}