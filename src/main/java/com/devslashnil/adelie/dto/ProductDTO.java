package com.devslashnil.adelie.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductDTO extends RepresentationModel<ProductDTO> implements BaseDTO {

    @NotEmpty
    private int id;

    @NotEmpty
    private String category;

    @NotEmpty
    private String name;

    @NotEmpty
    private int quantity;

    @NotEmpty
    private String desc;

    @NotEmpty
    private String weight;

    @NotEmpty
    private String volume;

    private LocalDateTime deletedAt;

}
