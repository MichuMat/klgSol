package com.example.demo.services;

import com.example.demo.commands.ProductCommand;
import com.example.demo.entities.Product;

public interface ProductService {

    Product create(ProductCommand productCommand);

    Product update(Long id, ProductCommand productCommand);
}
