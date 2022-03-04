package com.devslashnil.adelie.service.impl;

import com.devslashnil.adelie.model.Order;
import com.devslashnil.adelie.repository.OrderRepository;
import com.devslashnil.adelie.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl extends CrudServiceImpl<Order, Integer, OrderRepository> implements OrderService {

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        super(orderRepository);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Order> getUserOrders(String userLogin) {
        return null;
    }

    @Override
    public Order getUserOrder(String userLogin, int orderId) {
        // if order doesn't belong to user throw error
        return super.findById(orderId);
    }

    @Override
    public Page<Order> fetchFiltered(String executed, String created, PageRequest request) {
        return null;
    }

    @Override
    public Order createUserOrder(String userLogin, int deliveryCost, String cardNumber) {
        return null;
    }

    @Override
    public void updateStatus(long orderId, boolean executed) {

    }
}
