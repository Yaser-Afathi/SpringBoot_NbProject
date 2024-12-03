package com.example.NoBsProject.Product.services;

import com.example.NoBsProject.Product.Command;
import com.example.NoBsProject.Product.ProductRepository;
import com.example.NoBsProject.Product.model.Product;
import com.example.NoBsProject.Product.model.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements Command<Product, ProductDTO> {

    private final ProductRepository productRepository;
    public CreateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Product product) {
        Product saveProduct = this.productRepository.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(saveProduct));
    }
}
