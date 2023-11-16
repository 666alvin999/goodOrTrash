package com.goodortrash.app.infrastructure.adapter;

import com.goodortrash.app.domain.bean.MarcelDialog;
import com.goodortrash.app.domain.port.MarcelDialogPort;
import com.goodortrash.app.infrastructure.dao.OraTextDao;
import com.goodortrash.app.infrastructure.dto.OraText;
import com.goodortrash.app.infrastructure.mapper.OraTextMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class OraTextAdapter implements MarcelDialogPort {

    private OraTextDao oraTextDao;
    private OraTextMapper oraTextMapper;

    @Override
    public List<MarcelDialog> getDialogByDialogType(String dialogType) {
        List<OraText> daoResult = oraTextDao.getTextByTextType(dialogType);

        return oraTextMapper.mapAllToBusiness(daoResult);
    }
}
