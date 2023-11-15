package com.goodortrash.app.presentation.controller;

import com.goodortrash.app.presentation.presenter.ProductPresenter;
import com.goodortrash.app.presentation.port.GetProductByReferencePort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final GetProductByReferencePort getProductByReference;
    private final ProductPresenter productPresenter;

    public ProductController(GetProductByReferencePort getProductByReference, ProductPresenter productPresenter) {
        this.getProductByReference = getProductByReference;
        this.productPresenter = productPresenter;
    }

    @PostMapping("/fetch")
    public ResponseEntity<String> fetchProductByReference(String reference) {
        return productPresenter.present(getProductByReference.execute(reference));
    }

}
