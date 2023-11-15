package com.goodortrash.app.presentation.controller;

import com.goodortrash.app.domain.usecase.GetMarcelDialogById;
import com.goodortrash.app.presentation.presenter.MarcelDialogPresenter;
import com.goodortrash.app.presentation.presenter.ProductPresenter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/marcelDialogs")
public class MarcelDialogController {

    private final GetMarcelDialogById getMarcelDialogById;
    private final MarcelDialogPresenter marcelDialogPresenter;

    public MarcelDialogController(GetMarcelDialogById getMarcelDialogById, MarcelDialogPresenter marcelDialogPresenter) {
        this.getMarcelDialogById = getMarcelDialogById;
        this.marcelDialogPresenter = marcelDialogPresenter;
    }

    @PostMapping("/fetch")
    public ResponseEntity<String> fetchMarcelDialogById(String id) {
        return marcelDialogPresenter.present(getMarcelDialogById.execute(id));
    }

}
