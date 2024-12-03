package com.example.NoBsProject.Product.services;

import com.example.NoBsProject.Product.Command;
import com.example.NoBsProject.Product.ProductRepository;
import com.example.NoBsProject.Product.exceptions.ProductNotFoundException;
import com.example.NoBsProject.Product.model.Product;
import com.example.NoBsProject.Product.model.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteProductService implements Command<Integer, Void> {

    private final ProductRepository productRepository;
    public DeleteProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public ResponseEntity<Void> execute(Integer id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            productRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        throw new ProductNotFoundException();
    }
}
