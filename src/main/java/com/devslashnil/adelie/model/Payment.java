package com.devslashnil.adelie.model;

import java.io.Serial;
import java.io.Serializable;
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
@Table(name = "payment_details")
public class Payment extends TimestampEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -6498274545708477427L;

    private String provider;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable=false)
    private PaymentStatus status;
}
