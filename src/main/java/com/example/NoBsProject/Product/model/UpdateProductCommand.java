package com.example.NoBsProject.Product.model;

import lombok.Getter;

@Getter
public class UpdateProductCommand {
    private int id;
    private Product product;

    public UpdateProductCommand(int id, Product product) {
        this.id = id;
        this.product = product;
    }

}
