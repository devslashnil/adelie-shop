package com.devslashnil.adelie.dto;

import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class CustomerDTO extends RepresentationModel<CustomerDTO> {

    public static final String ALPHANUMERIC = "^[a-zA-Z0-9]+$";
    public static final String EMAIL_REGEX = "^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]+$";
    public static final String USER_ADDRESS_REGEX = "^[^#$%^*()']*$";

    @NotEmpty
    @Size(max = 50)
    @Pattern(regexp = EMAIL_REGEX)
    private String email;

    @Size(min = 6, max = 50)
    @Pattern(regexp = ALPHANUMERIC)
    private String password;

    @NotEmpty
    @Size(max = 50)
    @Pattern(regexp = "^[\\pL '-]+$")
    private String firstName;

    @NotEmpty
    @Size(max = 50)
    @Pattern(regexp = "^[\\pL '-]+$")
    private String lastName;

    @NotEmpty
    private LocalDate birthdate;

    @NotEmpty
    @Size(max = 50)
    private String country;

    @NotEmpty
    private int postalCode;

    @NotEmpty
    @Size(max = 100)
    @Pattern(regexp = USER_ADDRESS_REGEX)
    private String addressLine1;

    @NotEmpty
    @Size(max = 100)
    @Pattern(regexp = USER_ADDRESS_REGEX)
    private String addressLine2;

}
