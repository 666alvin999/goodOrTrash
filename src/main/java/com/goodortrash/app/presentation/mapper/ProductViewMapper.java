package com.goodortrash.app.presentation.mapper;

import com.goodortrash.app.domain.bean.Product;
import com.goodortrash.app.presentation.dto.ProductView;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductViewMapper {

    public ProductView mapToViewModel(Product product) {
        return new ProductView(
                product.id(),
                product.name(),
                product.brand(),
                product.categories(),
                product.packing(),
                product.origins(),
                (product.ecoScore() <= 'C'),
                product.explanation(),
                product.urlToOpenFoodFacts()
        );
    }

    public List<ProductView> mapAllToViewModel(List<Product> products) {
        return products.stream().map(this::mapToViewModel).toList();
    }

}
