package com.example.NoBsProject.Product.services;

import com.example.NoBsProject.Product.ProductRepository;
import com.example.NoBsProject.Product.Query;
import com.example.NoBsProject.Product.exceptions.ProductNotFoundException;
import com.example.NoBsProject.Product.model.Product;
import com.example.NoBsProject.Product.model.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductService implements Query<Integer, ProductDTO> {

    private final ProductRepository productRepository;
    public GetProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public ResponseEntity<ProductDTO> execute(Integer input) {
        Optional<Product> productOptional = productRepository.findById(input);
        if (productOptional.isPresent()) {
            return ResponseEntity.ok(new ProductDTO(productOptional.get()));
        }
        throw new ProductNotFoundException();
    }
}
