package com.goodortrash.app.presentation.presenter;

import com.goodortrash.app.domain.bean.Product;
import com.goodortrash.app.presentation.mapper.ProductViewMapper;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductPresenter {

    private ProductViewMapper productViewMapper;

    public ResponseEntity<String> present(Product product) {

        return ResponseEntity.ok(new Gson().toJson(productViewMapper.mapToViewModel(product)));
    }

}
