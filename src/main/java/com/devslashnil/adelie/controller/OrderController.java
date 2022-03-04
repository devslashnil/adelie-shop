package com.devslashnil.adelie.controller;

import com.devslashnil.adelie.controller.assembler.OrderDtoAssembler;
import com.devslashnil.adelie.dto.OrderDTO;
import com.devslashnil.adelie.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("customer/orders")
@ExposesResourceFor(OrderDTO.class)
@Secured({"ROLE_USER"})
public class OrderController {

    private final OrderService orderService;
    private final OrderDtoAssembler orderDtoAssembler = new OrderDtoAssembler();

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * View Orders
     *
     * @return orders list of the specified customer
     */
    @PostMapping
    public List<OrderDTO> getOrders(Principal principal) {
        return orderService.getUserOrders(principal.getName()).stream()
                .map(orderDtoAssembler::toModel)
                .collect(toList());
    }

    /**
     * View a single order.
     *
     * @return order of the specified customer
     */
    @GetMapping(value = "/{orderId}")
    public OrderDTO getOrder(Principal principal, @PathVariable int orderId) {
        String email = principal.getName();
        return orderDtoAssembler.toModel(orderService.getUserOrder(email, orderId));
    }

}
