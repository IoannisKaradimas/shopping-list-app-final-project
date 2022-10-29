package com.codingfactory.aueb.shoppinglist.service;

import com.codingfactory.aueb.shoppinglist.entity.Product;

import java.util.List;

public interface ShoppingListService {

    Product saveProduct(Product product);

    Product findProductById(Long productId);

    List<Product> findAllProducts();

    Product updateProduct(Product product, Long productId);

    void deleteProductById(Long productId);
}
