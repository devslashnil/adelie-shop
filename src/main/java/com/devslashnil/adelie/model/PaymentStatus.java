package com.devslashnil.adelie.model;

import java.io.Serial;
import java.io.Serializable;
import javax.persistence.*;
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
@Table(name = "payment_status")
public class PaymentStatus extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -4907020584794889225L;

    private String name;
}
