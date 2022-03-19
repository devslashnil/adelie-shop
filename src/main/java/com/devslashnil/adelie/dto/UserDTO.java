package com.devslashnil.adelie.dto;

import com.devslashnil.adelie.dto.patterns.Patterns;
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public enum UserDTO {;

    private interface Email {

        @NotEmpty
        @Size(max = 50)
        @Pattern(regexp = Patterns.EMAIL_REGEX)
        String getEmail();

    }

    private interface Password {

        @Size(min = 6, max = 50)
        @Pattern(regexp = Patterns.ALPHANUMERIC)
        String getPassword();

    }

    private interface FirstName {

        @NotEmpty
        @Size(max = 50)
        @Pattern(regexp = Patterns.NAME)
        String getFirstName();

    }

    private interface LastName {

        @NotEmpty
        @Size(max = 50)
        @Pattern(regexp = Patterns.NAME)
        String getLastName();

    }

    private interface Birthdate {

        @NotEmpty
        LocalDate getBirthdate();

    }

    private interface Country {

        @NotEmpty
        @Size(max = 50)
        String getCountry();

    }

    private interface PostalCode {

        @NotEmpty
        Integer getPostalCode();

    }

    private interface AddressLine1 {

        @NotEmpty
        @Size(max = 100)
        @Pattern(regexp = Patterns.USER_ADDRESS_REGEX)
        String getAddressLine1();

    }

    private interface AddressLine2 {

        @NotEmpty
        @Size(max = 100)
        @Pattern(regexp = Patterns.USER_ADDRESS_REGEX)
        String getAddressLine2();

    }

    private interface Roles {

        @NotEmpty
        List<Role> getRoles();

    }

    @AllArgsConstructor
    @Getter
    public enum Role {

        ROLE_CUSTOMER("ROLE_CUSTOMER"),
        ROLE_EMPLOYEE("ROLE_EMPLOYEE");

        private final String value;

    }

    public interface BaseInfo extends BaseDTO, Email, Password, FirstName, LastName, Roles {
    }

    public enum Response {;

        @EqualsAndHashCode(callSuper = true)
        @Value
        public static class Employee extends RepresentationModel<UserDTO.Response.Employee>
                implements BaseInfo {

            Integer id;
            String email;
            String password;
            String firstName;
            String lastName;
            List<Role> roles = new ArrayList<>(List.of(Role.ROLE_EMPLOYEE));

        }

        @EqualsAndHashCode(callSuper = true)
        @Value
        public static class Customer extends RepresentationModel<UserDTO.Response.Customer>
                implements BaseInfo, Birthdate, Country, PostalCode, AddressLine1, AddressLine2  {

            Integer id;
            String email;
            String password;
            String firstName;
            String lastName;
            LocalDate birthdate;
            String country;
            String postalCode;
            String addressLine1;
            String addressLine2;
            List<Role> roles = new ArrayList<>(List.of(Role.ROLE_CUSTOMER));

        }

    }

}
