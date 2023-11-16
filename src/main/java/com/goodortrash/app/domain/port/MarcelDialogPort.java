package com.goodortrash.app.domain.port;

import com.goodortrash.app.domain.bean.MarcelDialog;

import java.util.List;

public interface MarcelDialogPort {

    List<MarcelDialog> getDialogByDialogType(String dialogType);

}
