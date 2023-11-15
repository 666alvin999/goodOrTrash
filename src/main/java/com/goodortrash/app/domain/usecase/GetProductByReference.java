package com.goodortrash.app.domain.usecase;

import com.goodortrash.app.domain.bean.Product;
import com.goodortrash.app.domain.port.ProductPort;
import com.goodortrash.app.presentation.port.GetProductByReferencePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GetProductByReference implements GetProductByReferencePort {

    private ProductPort productAdapter;

    public Product execute(String reference) {
        return productAdapter.getProductByReference(reference);
    }

}
