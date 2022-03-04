package com.devslashnil.adelie.controller.assembler;

import com.devslashnil.adelie.dto.OrderDTO;
import com.devslashnil.adelie.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.lang.NonNull;

import java.util.List;

public class OrderDtoAssembler implements RepresentationModelAssembler<Order, OrderDTO> {

    @NonNull
    @Override
    public OrderDTO toModel(@NonNull Order order) {
        return OrderDTO.builder()
                .id(order.getId())
                .email(order.getCustomer().getEmail())
                .total(order.getTotal())
                .status(order.getStatus().getName())
                .deliveryMethod(order.getDeliveryMethod())
                .createdAt(order.getCreatedAt())
                .modifiedAt(order.getModifiedAt())
                .build();
    }

    public PageImpl<OrderDTO> toModel(Page<Order> page) {
        List<OrderDTO> dtoList = page.map(this::toModel).toList();
        return new PageImpl<>(dtoList, page.getPageable(), page.getTotalElements());
    }

    public OrderDTO[] toDtoArray(List<Order> entities) {
        return toCollectionModel(entities).getContent().toArray(new OrderDTO[entities.size()]);
    }

}
