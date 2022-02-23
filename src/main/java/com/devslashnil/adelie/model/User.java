package com.devslashnil.adelie.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@MappedSuperclass
public class User extends BaseEntity {

    @NotEmpty(message = "User's email is required")
    private String email;

    @NotEmpty(message = "User's password is required")
    private String password;

    @Column(name = "first_name")
    @NotEmpty(message = "User's first name is required")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "User's last name is required")
    private String lastName;

}
