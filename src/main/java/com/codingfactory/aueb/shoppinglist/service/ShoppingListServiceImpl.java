package com.codingfactory.aueb.shoppinglist.service;

import com.codingfactory.aueb.shoppinglist.entity.Product;
import com.codingfactory.aueb.shoppinglist.exception.ProductNotFoundException;
import com.codingfactory.aueb.shoppinglist.repository.ProductRepository;
import com.codingfactory.aueb.shoppinglist.util.enums.ExceptionEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShoppingListServiceImpl implements ShoppingListService{

    private final ProductRepository productRepository;

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow(() -> {
            throw new ProductNotFoundException(ExceptionEnum.NOT_FOUND_ERROR.getCode(), ExceptionEnum.NOT_FOUND_ERROR.getDescription());
        });
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(Product product, Long productId) {
        Product productToUpdate = productRepository.findById(productId).orElseThrow(() -> {
            throw new ProductNotFoundException(ExceptionEnum.NOT_FOUND_ERROR.getCode(), ExceptionEnum.NOT_FOUND_ERROR.getDescription());
        });

        productToUpdate.setProductDescription(product.getProductDescription());
        productToUpdate.setQuantity(product.getQuantity());

        return productRepository.save(productToUpdate);
    }

    @Override
    public void deleteProductById(Long productId) {
        productRepository.deleteById(productId);
    }
}
