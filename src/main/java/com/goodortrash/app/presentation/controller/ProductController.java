package com.goodortrash.app.presentation.controller;

import com.goodortrash.app.presentation.port.GetAllProductsPort;
import com.goodortrash.app.presentation.presenter.ProductPresenter;
import com.goodortrash.app.presentation.port.GetProductByReferencePort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final GetProductByReferencePort getProductByReference;
    private final GetAllProductsPort getAllProducts;
    private final ProductPresenter productPresenter;

    public ProductController(GetProductByReferencePort getProductByReference, GetAllProductsPort getAllProducts, ProductPresenter productPresenter) {
        this.getProductByReference = getProductByReference;
        this.getAllProducts = getAllProducts;
        this.productPresenter = productPresenter;
    }

    @PostMapping("/fetch")
    public ResponseEntity<String> fetchProductByReference(String reference) {
        return productPresenter.present(getProductByReference.execute(reference));
    }

    @GetMapping("/fetchAll")
    @CrossOrigin(origins = {"http://localhost:3000", "http://172.20.10.2:8081"})
    public ResponseEntity<String> fetchAllProducts() {
        return productPresenter.presentAll(getAllProducts.execute());
    }

}
