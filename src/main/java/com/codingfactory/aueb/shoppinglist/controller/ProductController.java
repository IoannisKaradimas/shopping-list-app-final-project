package com.codingfactory.aueb.shoppinglist.controller;

import com.codingfactory.aueb.shoppinglist.entity.Product;
import com.codingfactory.aueb.shoppinglist.service.ShoppingListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static com.codingfactory.aueb.shoppinglist.util.constants.ControllerConstants.Parameters.PRODUCT_ID;
import static com.codingfactory.aueb.shoppinglist.util.constants.ControllerConstants.Urls.PRODUCTS;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(PRODUCTS)
public class ProductController {

    private final ShoppingListService shoppingListService;

    /**
     * Saves a new product in the shopping list.
     * id of the product is auto-generated.
     *
     * @param product the new product to be saved in the database
     * @return a response entity with new product's id and attributes {@link Product}
     * @throws URISyntaxException
     */
    @PostMapping
    public ResponseEntity saveProduct(@RequestBody Product product) throws URISyntaxException {
        Product savedProduct = shoppingListService.saveProduct(product);
        log.info("Invoking ProductController POST Endpoint: {}", PRODUCTS);
        return ResponseEntity.created(new URI("/products" + savedProduct.getProductId())).body(savedProduct);
    }

    /**
     * Retrieves all the saved products
     *
     * @return a list with all the products in the database {@link Product}
     */
    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts() {
        log.info("Invoking ProductController GET Endpoint: {}", PRODUCTS);
        return new ResponseEntity<>(shoppingListService.findAllProducts(), HttpStatus.OK);
    }

    /**
     * Retrieves a specific product based on the id
     *
     * @param id the product's id
     * @return a specific product {@link Product}
     */
    @GetMapping(PRODUCT_ID)
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        log.info("Invoking ProductController GET Endpoint: {}", PRODUCTS + PRODUCT_ID);
        return new ResponseEntity<>(shoppingListService.findProductById(id), HttpStatus.OK);
    }

    /**
     * Updates an existing product's attributes
     *
     * @param id the product's id
     * @param product the product to be updated
     * @return an updated product
     */
    @PutMapping(PRODUCT_ID)
    public ResponseEntity updateProduct(@PathVariable Long id, @RequestBody Product product) {
        log.info("Invoking ProductController PUT Endpoint: {}", PRODUCTS + PRODUCT_ID);
        return new ResponseEntity<>(shoppingListService.updateProduct(product, id), HttpStatus.OK);
    }

    /**
     * Deletes a product from the shopping list
     *
     * @param id the product's id
     * @return a 200 response if the product was successfully deleted
     */
    @DeleteMapping(PRODUCT_ID)
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        shoppingListService.deleteProductById(id);
        log.info("Invoking ProductController DELETE Endpoint: {}", PRODUCTS + PRODUCT_ID);
        return ResponseEntity.ok().build();
    }
}
