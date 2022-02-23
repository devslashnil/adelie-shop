package com.devslashnil.adelie.model;

import java.time.LocalDate;
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
@Table(name = "customer")
public class Customer extends User {

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable=false)
    @NotEmpty(message = "Customer's address is required")
    private Address address;

    private LocalDate birthdate;

}
