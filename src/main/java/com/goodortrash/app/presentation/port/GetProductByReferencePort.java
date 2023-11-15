package com.goodortrash.app.presentation.port;

import com.goodortrash.app.domain.bean.Product;

public interface GetProductByReferencePort {

    Product execute(String reference);

}
