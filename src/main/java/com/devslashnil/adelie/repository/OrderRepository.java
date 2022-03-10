package com.devslashnil.adelie.repository;

import com.devslashnil.adelie.model.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order, Integer> {}
