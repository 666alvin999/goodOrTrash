package com.goodortrash.app.presentation.port;

import com.goodortrash.app.domain.bean.Product;

import java.util.List;

public interface GetAllProductsPort {

    List<Product> execute();

}
