package com.goodortrash.app.domain.usecase;

import com.goodortrash.app.domain.bean.MarcelDialog;
import com.goodortrash.app.domain.port.MarcelDialogPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.goodortrash.app.domain.bean.MarcelDialog.marcelDialog;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetMarcelDialogByIdTest {

    private GetMarcelDialogById getMarcelDialogById;

    @Mock
    private MarcelDialogPort marcelDialogAdapter;

    @BeforeEach
    public void setUp() {
        getMarcelDialogById = new GetMarcelDialogById(marcelDialogAdapter);
    }

    @Test
    public void givenValidId_when_GettingMarcelDialogById_thenGetMarcelDialog() {
        //Arrange
        MarcelDialog marcelDialog = marcelDialog()
                .text("PAPA BAISE TES MORTS")
                .dialogType("BAD-1")
                .build();

        when(marcelDialogAdapter.getDialogById("PAPA")).thenReturn(marcelDialog);

        //Act
        MarcelDialog output = getMarcelDialogById.execute("PAPA");

        //Assert
        assertThat(output).isEqualTo(marcelDialog);
    }

}