package com.goodortrash.app.domain.usecase;

import com.goodortrash.app.domain.bean.Product;
import com.goodortrash.app.domain.port.ProductPort;
import com.goodortrash.app.presentation.port.GetAllProductsPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GetAllProducts implements GetAllProductsPort {

    private ProductPort productAdapter;

    public List<Product> execute() {
        return productAdapter.getAllProducts();
    }

}
