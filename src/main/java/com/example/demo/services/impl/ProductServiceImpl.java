package com.example.demo.services.impl;

import com.example.demo.commands.ProductCommand;
import com.example.demo.entities.Product;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product create(ProductCommand productCommand) {
        Product product = new Product(productCommand.getName(), productCommand.getPrice());
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, ProductCommand productCommand) {
        Optional<Product> productOptional = productRepository.findById(id);

        if (!productOptional.isPresent()) {
            throw new NotFoundException();
        }

        Product product = productOptional.get();
        product.setName(productCommand.getName());
        product.setPrice(productCommand.getPrice());
        return productRepository.save(product);
    }
}
