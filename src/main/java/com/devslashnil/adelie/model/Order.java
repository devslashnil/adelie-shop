package com.devslashnil.adelie.model;

import java.math.BigDecimal;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_details")
public class Order extends TimestampEntity {

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    @NotEmpty(message = "Customer of a order is required")
    private Customer customer;

    private BigDecimal total;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    @NotEmpty(message = "Status of a order is required")
    private OrderStatus status;

    @Column(name = "delivery_method")
    private String deliveryMethod;

}
