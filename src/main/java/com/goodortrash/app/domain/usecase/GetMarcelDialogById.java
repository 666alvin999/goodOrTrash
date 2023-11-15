package com.goodortrash.app.domain.usecase;

import com.goodortrash.app.domain.bean.MarcelDialog;
import com.goodortrash.app.domain.port.MarcelDialogPort;
import com.goodortrash.app.presentation.port.GetMarcelDialogByIdPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetMarcelDialogById implements GetMarcelDialogByIdPort {

    private MarcelDialogPort marcelDialogAdapter;

    public MarcelDialog execute(String id) {
        return marcelDialogAdapter.getDialogById(id);
    }

}
