package com.codingfactory.aueb.shoppinglist.exception;

import lombok.Data;

@Data
public class CustomException extends RuntimeException{

    private String code;

    public CustomException(String code, String description) {
        super(description);
        this.code = code;
    }

    public CustomException(String code, String description, Throwable cause) {
        super(description, cause);
        this.code = code;
    }
}
