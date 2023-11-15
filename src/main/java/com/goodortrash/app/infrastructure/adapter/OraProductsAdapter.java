package com.goodortrash.app.infrastructure.adapter;

import com.goodortrash.app.domain.bean.Product;
import com.goodortrash.app.domain.port.ProductPort;
import com.goodortrash.app.infrastructure.dao.OraProductDao;
import com.goodortrash.app.infrastructure.dto.OraProduct;
import com.goodortrash.app.infrastructure.mapper.OraProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class OraProductsAdapter implements ProductPort {

    private OraProductDao oraProductDao;
    private OraProductMapper oraProductMapper;

    public Product getProductByReference(String reference) {
        Optional<OraProduct> daoResult = oraProductDao.getProductByReference(reference);

        return daoResult.map(oraProduct -> oraProductMapper.mapToBusiness(oraProduct)).orElse(null);
    }

}
