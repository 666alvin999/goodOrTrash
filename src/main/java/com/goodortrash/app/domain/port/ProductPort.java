package com.goodortrash.app.domain.port;

import com.goodortrash.app.domain.bean.Product;

import java.util.List;

public interface ProductPort {

    Product getProductByReference(String reference);

    List<Product> getAllProducts();

}
