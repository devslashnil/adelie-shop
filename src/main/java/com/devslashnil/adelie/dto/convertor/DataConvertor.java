package com.devslashnil.adelie.dto.convertor;

import org.modelmapper.ModelMapper;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public record DataConvertor<T, DTO extends RepresentationModel<DTO>>(ModelMapper modelMapper) {

     public <S extends T> DTO convertToDTO(S entity, Class<DTO> mappingClass) {
          return modelMapper.map(entity, mappingClass);
     }

     public <S extends T> List<DTO> convertToDTO(Iterable<S> entities, Class<DTO> mappingClass) {
          return StreamSupport.stream(entities.spliterator(), false)
                  .map((entity) -> this.convertToDTO(entity, mappingClass))
                  .collect(Collectors.toList());
     }

     public <S extends T> List<DTO> convertToDTO(List<S> entities, Class<DTO> mappingClass) {
          return entities.stream()
                  .map((entity) -> this.convertToDTO(entity, mappingClass))
                  .collect(Collectors.toList());
     }

     public <S extends T> S convertToEntity(DTO dto, Class<S> entityClass) {
          return modelMapper.map(dto, entityClass);
     }

     public <S extends T> List<S> convertToEntity(Iterable<DTO> dtos, Class<S> entityClass) {
          return StreamSupport.stream(dtos.spliterator(), false)
                  .map((dto) -> this.convertToEntity(dto, entityClass))
                  .collect(Collectors.toList());
     }

}
