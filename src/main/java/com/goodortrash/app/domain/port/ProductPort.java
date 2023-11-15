package com.goodortrash.app.domain.port;

import com.goodortrash.app.domain.bean.Product;

public interface ProductPort {

    public Product getProductByReference(String reference);

}
