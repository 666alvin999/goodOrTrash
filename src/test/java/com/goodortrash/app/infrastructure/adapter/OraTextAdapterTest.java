package com.goodortrash.app.infrastructure.adapter;

import com.goodortrash.app.domain.bean.MarcelDialog;
import com.goodortrash.app.infrastructure.dao.OraTextDao;
import com.goodortrash.app.infrastructure.dto.OraText;
import com.goodortrash.app.infrastructure.mapper.OraTextMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static com.goodortrash.app.domain.bean.MarcelDialog.marcelDialog;
import static com.goodortrash.app.infrastructure.dto.OraText.oraText;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OraTextAdapterTest {

    private OraTextAdapter oraTextAdapter;

    @Mock
    OraTextDao oraTextDao;

    @Mock
    OraTextMapper oraTextMapper;

    @BeforeEach
    public void setUp() {
        oraTextAdapter = new OraTextAdapter(oraTextDao, oraTextMapper);
    }

    @Test
    public void givenValidId_whenGettingMarcelDialogById_ThenGetMarcelDialog() {
        //Arrange
        OraText oraText = oraText()
                .id("PAPA")
                .text("PAPA BAISE TES MORTS")
                .textType("BAD-1")
                .build();

        MarcelDialog marcelDialog = marcelDialog()
                .text("PAPA BAISE TES MORTS")
                .dialogType("BAD-1")
                .build();

        when(oraTextDao.getTextById("PAPA")).thenReturn(Optional.of(oraText));
        when(oraTextMapper.mapToBusiness(oraText)).thenReturn(marcelDialog);

        //Act
        MarcelDialog output = oraTextAdapter.getDialogById("PAPA");

        //Assert
        assertThat(output).isEqualTo(marcelDialog);
    }

    @Test
    public void givenInvalidId_whenGettingMarcelDialogById_thenGetNull() {
        //Arrange
        when(oraTextDao.getTextById("0002")).thenReturn(Optional.empty());

        //Act
        MarcelDialog output = oraTextAdapter.getDialogById("0002");

        //Assert
        assertThat(output).isNull();
    }
}