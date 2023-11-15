package com.goodortrash.app.presentation.port;

import com.goodortrash.app.domain.bean.MarcelDialog;

public interface GetMarcelDialogByIdPort {

    MarcelDialog execute(String id);

}
