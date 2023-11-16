package com.goodortrash.app.domain.usecase;

import com.goodortrash.app.domain.bean.MarcelDialog;
import com.goodortrash.app.domain.port.MarcelDialogPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.goodortrash.app.domain.bean.MarcelDialog.marcelDialog;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetMarcelDialogByDialogTypeTest {

    private GetMarcelDialogByDialogType getMarcelDialogByDialogType;

    @Mock
    private MarcelDialogPort marcelDialogAdapter;

    @BeforeEach
    public void setUp() {
        getMarcelDialogByDialogType = new GetMarcelDialogByDialogType(marcelDialogAdapter);
    }

    @Test
    public void givenValidId_when_GettingMarcelDialogById_thenGetMarcelDialog() {
        //Arrange
        List<MarcelDialog> marcelDialog = List.of(marcelDialog()
                .text("PAPA BAISE TES MORTS")
                .dialogType("BAD")
                .build());

        when(marcelDialogAdapter.getDialogByDialogType("PAPA")).thenReturn(marcelDialog);

        //Act
        List<MarcelDialog> output = getMarcelDialogByDialogType.execute("PAPA");

        //Assert
        assertThat(output).isEqualTo(marcelDialog);
    }

}