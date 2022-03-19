package com.devslashnil.adelie.repository;

import com.devslashnil.adelie.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
