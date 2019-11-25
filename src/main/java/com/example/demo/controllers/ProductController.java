package com.example.demo.controllers;

import com.example.demo.commands.ProductCommand;
import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("")
    public ResponseEntity<Product> createProduct(@RequestBody ProductCommand productCommand) {
        Product product = productService.create(productCommand);
        return ResponseEntity.ok(product);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody ProductCommand productCommand) {
        Product product = productService.update(id, productCommand);
        return ResponseEntity.ok(product);
    }
}
