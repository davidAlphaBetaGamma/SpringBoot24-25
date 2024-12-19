package com.example.ShoppingCart.service;
import com.example.ShoppingCart.dto.ProductRequest;
import com.example.ShoppingCart.dto.ProductResponse;
import com.example.ShoppingCart.entity.Product;
import com.example.ShoppingCart.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    private ProductRepository productRepository;

    public void creatProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .availableQuantity(productRequest.getAvailableQuantity())
                .price(productRequest.getPrice())

                .build();

        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    public void removeProduct(int productId) {
        productRepository.deleteById(productId);
    }

    private ProductResponse mapToProductResponse(Product product) {

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .availableQuantity(product.getAvailableQuantity())
                .price(product.getPrice())

                .build();
    }
}
