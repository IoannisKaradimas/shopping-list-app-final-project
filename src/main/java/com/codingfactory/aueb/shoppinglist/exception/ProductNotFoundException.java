package com.codingfactory.aueb.shoppinglist.exception;

public class ProductNotFoundException extends CustomException{

    public ProductNotFoundException(String code, String description) {
        super(code, description);
    }

    public ProductNotFoundException(String code, String description, Throwable cause) {
        super(code, description, cause);
    }
}
