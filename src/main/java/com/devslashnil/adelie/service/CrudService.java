package com.devslashnil.adelie.service;

import org.springframework.hateoas.RepresentationModel;

public interface CrudService <ID extends Number, DTO extends RepresentationModel<DTO>> {

    DTO create(DTO entityDTO);

    DTO findById(ID id);

    Iterable<DTO> findAllById(Iterable<ID> ids);

    Iterable<DTO> findAll();

    DTO update(DTO entityDTO);

    void deleteById(ID  id);

    void delete(DTO entityDTO);

    void deleteAllById(Iterable<ID> ids);

//    void deleteAll(Iterable<? extends DTO> entities);

    void deleteAll();

}
