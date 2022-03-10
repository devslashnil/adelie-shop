package com.devslashnil.adelie.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.RepresentationModel;

import java.time.LocalDateTime;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductDTO extends RepresentationModel<ProductDTO> {

    private int id;
    private String category;
    private String name;
    private int quantity;
    private String desc;
    private String weight;
    private String volume;
    private LocalDateTime deletedAt;

}
