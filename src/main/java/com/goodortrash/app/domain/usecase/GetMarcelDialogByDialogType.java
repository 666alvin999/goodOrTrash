package com.goodortrash.app.domain.usecase;

import com.goodortrash.app.domain.bean.MarcelDialog;
import com.goodortrash.app.domain.port.MarcelDialogPort;
import com.goodortrash.app.presentation.port.GetMarcelDialogByIdPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetMarcelDialogByDialogType implements GetMarcelDialogByIdPort {

    private MarcelDialogPort marcelDialogAdapter;

    public List<MarcelDialog> execute(String dialogType) {
        return marcelDialogAdapter.getDialogByDialogType(dialogType);
    }

}
