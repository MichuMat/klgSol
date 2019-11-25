package com.example.demo.controllers;

import com.example.demo.commands.ProductCommand;
import com.example.demo.entities.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @LocalServerPort
    int port;

    private RestTemplate restTemplate = new RestTemplate();

    URI getUri(String path) throws URISyntaxException {
        return new URI("http://localhost:" + port + "/products" + path);
    }

    @Test
    void createProductSuccess() throws URISyntaxException {


        ProductCommand productCommand = new ProductCommand("test", new BigDecimal(12));
        ResponseEntity<Product> result = restTemplate.postForEntity(getUri(""), productCommand, Product.class);

        assertEquals(200, result.getStatusCode().value());
        assertEquals(Objects.requireNonNull(result.getBody()).getName(), productCommand.getName());
        assertEquals(result.getBody().getPrice(), productCommand.getPrice());
    }

    @Test
    void createProductError() throws URISyntaxException {

        ProductCommand productCommand = new ProductCommand(null, new BigDecimal(12));
        ResponseEntity<Product> result = restTemplate.postForEntity(getUri(""), productCommand, Product.class);

        assertEquals(200, result.getStatusCode().value());
        assertEquals(Objects.requireNonNull(result.getBody()).getName(), productCommand.getName());
        assertEquals(result.getBody().getPrice(), productCommand.getPrice());
    }

}
