package com.goodortrash.app.presentation.presenter;

import com.goodortrash.app.domain.bean.Product;
import com.goodortrash.app.presentation.mapper.ProductViewMapper;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ProductPresenter {

    private ProductViewMapper productViewMapper;

    public ResponseEntity<String> present(Product product) {

        return ResponseEntity.ok(new Gson().toJson(productViewMapper.mapToViewModel(product)));
    }

    public ResponseEntity<String> presentAll(List<Product> products) {

        return ResponseEntity.ok(new Gson().toJson(productViewMapper.mapAllToViewModel(products)));
    }

}
