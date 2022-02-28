package com.devslashnil.adelie.service;

import java.util.Optional;

public interface CrudService <T, ID> {
    <S extends T> S create(S entity);

    Optional<T> findById(ID id);

    Iterable<T> findAllById(Iterable<ID> ids);

    Iterable<T> findAll();

    <S extends T> S update(S entity);

    void deleteById(ID  id);

    void delete(T entity);

    void deleteAllById(Iterable<ID> ids);

    void deleteAll(Iterable<? extends T> entities);

    void deleteAll();

}
