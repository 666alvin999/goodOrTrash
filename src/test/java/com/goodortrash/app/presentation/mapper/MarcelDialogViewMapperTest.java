package com.goodortrash.app.presentation.mapper;

import com.goodortrash.app.domain.bean.MarcelDialog;
import com.goodortrash.app.presentation.dto.MarcelDialogView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import static com.goodortrash.app.domain.bean.MarcelDialog.marcelDialog;
import static com.goodortrash.app.presentation.dto.MarcelDialogView.marcelDialogView;
import static org.assertj.core.api.Assertions.assertThat;

@Component
public class MarcelDialogViewMapperTest {

    private MarcelDialogViewMapper marcelDialogViewMapper;

    @BeforeEach
    public void setUp() {
        marcelDialogViewMapper = new MarcelDialogViewMapper();
    }

    @Test
    public void shouldReturnMarcelDialogViewModel() {
        //Arrange
        MarcelDialog marcelDialog = marcelDialog()
                .text("PAPA BAISE TES MORTS")
                .dialogType("BAD-1")
                .build();

        //Act
        MarcelDialogView output = marcelDialogViewMapper.mapToMarcelDialogView(marcelDialog);

        //Assert
        MarcelDialogView expectedOutput = marcelDialogView()
                .text("PAPA BAISE TES MORTS")
                .dialogCssClass("aggressive")
                .associatedMarcelDesignName("mad-marcel-1")
                .build();

        assertThat(output).isEqualTo(expectedOutput);
    }

}
