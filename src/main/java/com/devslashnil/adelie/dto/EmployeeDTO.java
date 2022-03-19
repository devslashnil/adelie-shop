package com.devslashnil.adelie.dto;

import com.devslashnil.adelie.dto.patterns.Patterns;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class EmployeeDTO extends RepresentationModel<EmployeeDTO> implements BaseDTO {

   @NotEmpty
   private int id;

    @NotEmpty
    @Size(max = 50)
    @Pattern(regexp = Patterns.EMAIL_REGEX)
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

}
