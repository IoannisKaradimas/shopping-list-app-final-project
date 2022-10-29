package com.codingfactory.aueb.shoppinglist.util.enums;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ExceptionEnum {
    NOT_FOUND_ERROR("001", "Product not found");

    public final String code;
    public final String description;

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }
}
