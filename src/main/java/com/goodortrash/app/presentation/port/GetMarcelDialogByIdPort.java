package com.goodortrash.app.presentation.port;

import com.goodortrash.app.domain.bean.MarcelDialog;

import java.util.List;

public interface GetMarcelDialogByIdPort {

    List<MarcelDialog> execute(String id);

}
