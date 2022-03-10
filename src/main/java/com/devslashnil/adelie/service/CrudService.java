package com.devslashnil.adelie.service;

public interface CrudService <T, ID, DTO> {

    <S extends T> DTO create(S entity);

    DTO findById(ID id);

    Iterable<DTO> findAllById(Iterable<ID> ids);

    Iterable<DTO> findAll();

    <S extends T> DTO update(S entity);

    void deleteById(ID  id);

    void delete(T entity);

    void deleteAllById(Iterable<ID> ids);

    void deleteAll(Iterable<? extends T> entities);

    void deleteAll();

}
