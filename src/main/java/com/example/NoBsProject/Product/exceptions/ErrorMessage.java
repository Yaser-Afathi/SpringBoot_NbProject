package com.example.NoBsProject.Product.exceptions;

public enum ErrorMessage {
    PRODUCT_NOT_FOUND("Product Not found");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
