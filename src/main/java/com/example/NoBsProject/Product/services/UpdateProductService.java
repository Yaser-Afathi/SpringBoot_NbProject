package com.example.NoBsProject.Product.services;

import com.example.NoBsProject.Product.Command;
import com.example.NoBsProject.Product.ProductRepository;
import com.example.NoBsProject.Product.exceptions.ProductNotFoundException;
import com.example.NoBsProject.Product.model.Product;
import com.example.NoBsProject.Product.model.ProductDTO;
import com.example.NoBsProject.Product.model.UpdateProductCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateProductService implements Command<UpdateProductCommand, ProductDTO> {

    private final ProductRepository productRepository;
    public UpdateProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @Override
    public ResponseEntity<ProductDTO> execute(UpdateProductCommand command) {
        Optional<Product> productOptional = productRepository.findById(command.getId());
        if (productOptional.isPresent()){
            Product product = command.getProduct();
            product.setId(command.getId());
            productRepository.save(product);
            return ResponseEntity.ok(new ProductDTO(product));
        }
        throw new ProductNotFoundException();
    }


}
