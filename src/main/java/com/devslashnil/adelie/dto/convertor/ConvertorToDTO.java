package com.devslashnil.adelie.dto.convertor;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public abstract class ConvertorToDTO<T, DTO extends RepresentationModel<DTO>> {

     protected final ModelMapper modelMapper;

     public ConvertorToDTO() {
          this.modelMapper = new ModelMapper();
     }

     public abstract <S extends T> DTO convertToDTO(S entity);

     public <S extends T> List<DTO> convertToDTO(Iterable<S> entities) {
          return StreamSupport.stream(entities.spliterator(), false)
                  .map(this::convertToDTO)
                  .collect(Collectors.toList());
     }

}
