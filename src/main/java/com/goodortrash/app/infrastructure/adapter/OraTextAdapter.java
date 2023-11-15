package com.goodortrash.app.infrastructure.adapter;

import com.goodortrash.app.domain.bean.MarcelDialog;
import com.goodortrash.app.domain.port.MarcelDialogPort;
import com.goodortrash.app.infrastructure.dao.OraTextDao;
import com.goodortrash.app.infrastructure.dto.OraText;
import com.goodortrash.app.infrastructure.mapper.OraTextMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class OraTextAdapter implements MarcelDialogPort {

    private OraTextDao oraTextDao;
    private OraTextMapper oraTextMapper;

    @Override
    public MarcelDialog getDialogById(String id) {
        Optional<OraText> daoResult = oraTextDao.getTextById(id);

        return daoResult.map(oraText -> oraTextMapper.mapToBusiness(oraText)).orElse(null);
    }
}
