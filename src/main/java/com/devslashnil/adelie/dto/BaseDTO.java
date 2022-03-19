package com.devslashnil.adelie.dto;

import javax.validation.constraints.Positive;

public interface BaseDTO {

    @Positive Integer getId();

}
