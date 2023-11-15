package com.goodortrash.app.presentation.presenter;

import com.goodortrash.app.domain.bean.MarcelDialog;
import com.goodortrash.app.presentation.mapper.MarcelDialogViewMapper;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MarcelDialogPresenter {

    private MarcelDialogViewMapper marcelDialogViewMapper;

    public ResponseEntity<String> present(MarcelDialog marcelDialog) {
        return ResponseEntity.ok(new Gson().toJson(marcelDialogViewMapper.mapToMarcelDialogView(marcelDialog)));
    }

}
