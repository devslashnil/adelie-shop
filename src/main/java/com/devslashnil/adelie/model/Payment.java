package com.devslashnil.adelie.model;

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
@Table(name = "payment_details")
public class Payment extends TimestampEntity {

    private String provider;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable=false)
    private PaymentStatus status;

}
