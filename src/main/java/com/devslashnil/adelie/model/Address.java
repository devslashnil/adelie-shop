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
@Table(name = "user_address")
public class Address extends BaseEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = -4782140138430997669L;

    @NotEmpty(message = "Country of address is required")
    private String country;

    @NotEmpty(message = "City of address is required")
    private String city;

    @Column(name = "postal_code")
    @NotEmpty(message = "Postal code of address is required")
    private int postalCode;

    @Column(name = "address_line_1")
    @NotEmpty(message = "Address line 1 of address is required")
    private String addressLine1;

    @Column(name = "address_line_2")
    @NotEmpty(message = "Address line 2 of address is required")
    private String addressLine2;
}
