package com.goodortrash.app.presentation.presenter;

import com.goodortrash.app.domain.bean.MarcelDialog;
import com.goodortrash.app.presentation.dto.MarcelDialogView;
import com.goodortrash.app.presentation.mapper.MarcelDialogViewMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static com.goodortrash.app.domain.bean.MarcelDialog.marcelDialog;
import static com.goodortrash.app.presentation.dto.MarcelDialogView.marcelDialogView;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.util.StringUtils.trimAllWhitespace;

@ExtendWith(MockitoExtension.class)
class MarcelDialogPresenterTest {

    private MarcelDialogPresenter marcelDialogPresenter;

    @Mock
    private MarcelDialogViewMapper marcelDialogViewMapper;

    @BeforeEach
    public void setUp() {
        marcelDialogPresenter = new MarcelDialogPresenter(marcelDialogViewMapper);
    }

    @Test
    public void shouldReturnMarcelDialogViewModel() {
        //Arrange
        MarcelDialog marcelDialog = marcelDialog()
                .text("PAPA BAISE TES MORTS")
                .dialogType("BAD")
                .build();

        MarcelDialogView marcelDialogView = marcelDialogView()
                .text("PAPABAISETESMORTS")
                .dialogCssClass("aggressive")
                .associatedMarcelDesignName("mad-marcel")
                .build();

        when(marcelDialogViewMapper.mapToMarcelDialogView(marcelDialog)).thenReturn(marcelDialogView);

        //Act
        ResponseEntity<String> output = marcelDialogPresenter.present(marcelDialog);

        //Assert
        String expectedOutput = trimAllWhitespace("""
                {
                    "text":"PAPABAISETESMORTS",
                    "dialogCssClass":"aggressive",
                    "associatedMarcelDesignName":"mad-marcel"
                }""");

        assertThat(output).isEqualTo(ResponseEntity.ok(expectedOutput));
    }

}