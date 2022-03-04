package com.devslashnil.adelie.service;

import com.devslashnil.adelie.exception.EmptyCartException;
import com.devslashnil.adelie.exception.UnknownEntityException;
import com.devslashnil.adelie.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface OrderService extends CrudService<Order, Integer> {

    /**
     * Get All User Orders
     *
     * @return all the orders of the specified user
     */
    List<Order> getUserOrders(String userEmail);

    /**
     * Get Order By ID
     *
     * @return order of the specified user and id
     * @throws UnknownEntityException if the requested order does not exist
     */
    Order getUserOrder(String userEmail, int orderId);

    /**
     * @return orders filtered according to the passed parameters
     */
    Page<Order> fetchFiltered(String executed, String created, PageRequest request);

    /**
     * Create User's Order
     *
     * Creates new order for the specified user.
     *
     * @return newly created order
     * @throws EmptyCartException if the specified user cart is empty
     */
    Order createUserOrder(String userEmail, int deliveryCost, String cardNumber);

    /**
     * Update Order
     *
     * Updates a state of the order with the specified id
     */
    void updateStatus(long orderId, boolean executed);

}
