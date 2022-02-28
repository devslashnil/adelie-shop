package com.devslashnil.adelie.controller;

import java.util.List;
import java.util.Optional;

import com.devslashnil.adelie.exceptions.NoContentException;
import com.devslashnil.adelie.model.Product;
import com.devslashnil.adelie.service.ProductService;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Retrieve All Products
     */
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Product>> listAllProducts() {
        Iterable<Product> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    /**
     * Retrieve Single Product By ID
     */
    @GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getProduct(@PathVariable("productId") int productId) {
        Optional<Product> product = productService.findById(productId);
        if (product.isEmpty()) {
           throw new NoContentException();
        }
        return ResponseEntity.ok(product.get());
    }

}
