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

import java.util.List;
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
        List<OraText> oraTexts = List.of(oraText()
                .text("PAPA BAISE TES MORTS")
                .textType("BAD")
                .build());

        List<MarcelDialog> marcelDialogs = List.of(marcelDialog()
                .text("PAPA BAISE TES MORTS")
                .dialogType("BAD")
                .build());

        when(oraTextDao.getTextByTextType("BAD")).thenReturn(oraTexts);
        when(oraTextMapper.mapAllToBusiness(oraTexts)).thenReturn(marcelDialogs);

        //Act
        List<MarcelDialog> output = oraTextAdapter.getDialogByDialogType("BAD");

        //Assert
        assertThat(output).isEqualTo(marcelDialogs);
    }

    @Test
    public void givenInvalidId_whenGettingMarcelDialogById_thenGetNull() {
        //Arrange
        when(oraTextDao.getTextByTextType("0002")).thenReturn(List.of());

        //Act
        List<MarcelDialog> output = oraTextAdapter.getDialogByDialogType("0002");

        //Assert
        assertThat(output).isEmpty();
    }
}