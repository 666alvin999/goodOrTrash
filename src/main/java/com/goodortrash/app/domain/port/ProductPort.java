package com.goodortrash.app.domain.port;

import com.goodortrash.app.domain.bean.Product;

public interface ProductPort {

    Product getProductByReference(String reference);

}
