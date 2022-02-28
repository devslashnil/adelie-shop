package com.devslashnil.adelie.service;

import com.devslashnil.adelie.model.Product;
import com.devslashnil.adelie.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductService extends CrudServiceImpl<Product, Integer, ProductRepository> {

    @Autowired
    public ProductService(ProductRepository productRepository) {
        super(productRepository);
    }

}
