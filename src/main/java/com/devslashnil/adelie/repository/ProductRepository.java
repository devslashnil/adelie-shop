package com.devslashnil.adelie.repository;

import java.util.Optional;
import com.devslashnil.adelie.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    Optional<Product> findByName (String name);

}
