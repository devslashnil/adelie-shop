package com.devslashnil.adelie.controller;

import com.devslashnil.adelie.dto.ProductDTO;
import com.devslashnil.adelie.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "product")
@ExposesResourceFor(ProductDTO.class)
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * All the existing products, sorted by id.
     */
    @GetMapping
    public Iterable<ProductDTO> getProducts() {
        return productService.findAll();
    }

    /**
     * Viewing a single product.
     *
     * @return product with the specified id
     */
    @GetMapping(value = "/{productId}")
    public ProductDTO getProduct(@PathVariable int productId) {
        return productService.findById(productId);
    }

}
