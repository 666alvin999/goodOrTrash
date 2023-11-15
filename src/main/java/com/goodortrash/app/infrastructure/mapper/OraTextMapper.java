package com.goodortrash.app.infrastructure.mapper;

import com.goodortrash.app.domain.bean.MarcelDialog;
import com.goodortrash.app.infrastructure.dto.OraText;
import org.springframework.stereotype.Component;

import static com.goodortrash.app.domain.bean.MarcelDialog.marcelDialog;

@Component
public class OraTextMapper {

    public MarcelDialog mapToBusiness(OraText oraText) {

        return marcelDialog()
                .text(oraText.getText())
                .dialogType(oraText.getTextType())
                .build();
    }

}
