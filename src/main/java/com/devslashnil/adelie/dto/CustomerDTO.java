package com.devslashnil.adelie.dto;

import com.devslashnil.adelie.dto.patterns.Patterns;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerDTO extends RepresentationModel<CustomerDTO> implements BaseDTO {

    @NotEmpty
    private int id;

    @NotEmpty
    @Size(max = 50)
    @Pattern(regexp = Patterns.ALPHANUMERIC)
    private String email;

    @Size(min = 6, max = 50)
    @Pattern(regexp = Patterns.ALPHANUMERIC)
    private String password;

    @NotEmpty
    @Size(max = 50)
    @Pattern(regexp = Patterns.NAME)
    private String firstName;

    @NotEmpty
    @Size(max = 50)
    @Pattern(regexp = Patterns.NAME)
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
    @Pattern(regexp = Patterns.USER_ADDRESS_REGEX)
    private String addressLine1;

    @NotEmpty
    @Size(max = 100)
    @Pattern(regexp = Patterns.USER_ADDRESS_REGEX)
    private String addressLine2;

}
