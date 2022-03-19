package com.devslashnil.adelie.service;

import com.devslashnil.adelie.dto.CustomerDTO;
import org.springframework.hateoas.RepresentationModel;

import java.util.Optional;


public interface UserService <ID extends Number, DTO extends RepresentationModel<DTO>>
        extends CrudService<ID, DTO> {

    Optional<DTO> findByEmail(String email);

}
