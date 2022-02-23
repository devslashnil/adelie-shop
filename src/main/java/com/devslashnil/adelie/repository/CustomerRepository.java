package com.devslashnil.adelie.repository;

import java.util.Optional;
import com.devslashnil.adelie.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    Optional<Customer> findByEmail(String email);

}
