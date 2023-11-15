package com.goodortrash.app.infrastructure.mapper;

import com.goodortrash.app.domain.bean.MarcelDialog;
import com.goodortrash.app.infrastructure.dto.OraText;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.goodortrash.app.domain.bean.MarcelDialog.marcelDialog;
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
                .id("PAPA")
                .text("PAPA BAISE TES MORTS")
                .textType("BAD-1")
                .build();

        //Act
        MarcelDialog outputDialog = oraTextMapper.mapToBusiness(oraText);

        //Assert
        MarcelDialog expectedDialog = marcelDialog()
                .text("PAPA BAISE TES MORTS")
                .dialogType("BAD-1")
                .build();

        assertThat(outputDialog).isEqualTo(expectedDialog);
    }

}