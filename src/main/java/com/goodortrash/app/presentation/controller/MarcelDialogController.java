package com.goodortrash.app.presentation.controller;

import com.goodortrash.app.domain.usecase.GetMarcelDialogByDialogType;
import com.goodortrash.app.presentation.dto.RequestBodyWithDialogType;
import com.goodortrash.app.presentation.presenter.MarcelDialogPresenter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/marcelDialogs")
public class MarcelDialogController {

    private final GetMarcelDialogByDialogType getMarcelDialogByDialogType;
    private final MarcelDialogPresenter marcelDialogPresenter;

    public MarcelDialogController(GetMarcelDialogByDialogType getMarcelDialogByDialogType, MarcelDialogPresenter marcelDialogPresenter) {
        this.getMarcelDialogByDialogType = getMarcelDialogByDialogType;
        this.marcelDialogPresenter = marcelDialogPresenter;
    }

    @PostMapping("/fetch")
    @CrossOrigin(origins = {"http://localhost:3000", "http://172.20.10.2:8081"})
    public ResponseEntity<String> fetchMarcelDialogByDialogType(@RequestBody RequestBodyWithDialogType requestBody) {
        return marcelDialogPresenter.presentAll(getMarcelDialogByDialogType.execute(requestBody.getDialogType()));
    }

}
