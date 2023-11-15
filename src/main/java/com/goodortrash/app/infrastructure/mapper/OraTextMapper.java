package com.goodortrash.app.infrastructure.mapper;

import com.goodortrash.app.domain.bean.MarcelDialog;
import com.goodortrash.app.infrastructure.dto.OraText;

import static com.goodortrash.app.domain.bean.MarcelDialog.marcelDialog;

public class OraTextMapper {

    public MarcelDialog mapToBusiness(OraText oraText) {

        return marcelDialog()
                .text(oraText.getText())
                .moral(oraText.getMoral())
                .build();
    }

}
