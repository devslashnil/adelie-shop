package com.devslashnil.adelie.repository;

import com.devslashnil.adelie.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
