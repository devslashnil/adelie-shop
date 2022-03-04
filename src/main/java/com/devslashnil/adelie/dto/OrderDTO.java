package com.devslashnil.adelie.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class OrderDTO extends RepresentationModel<OrderDTO> {

    private int id;
    private String email;
    private BigDecimal total;
    // LATER: add payment id
    private String status;
    private String deliveryMethod;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

}
