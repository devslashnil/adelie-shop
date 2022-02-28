package com.devslashnil.adelie.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@Slf4j
public abstract class CrudServiceImpl<T, ID, R extends CrudRepository<T, ID>>
        implements CrudService<T,ID> {

    private final R dao;

    protected CrudServiceImpl(R dao) {
        this.dao = dao;
    }

    @Override
    public <S extends T> S create(S entity) {
        return dao.save(entity);
    }

    @Override
    public Optional<T> findById(ID id) {
        return dao.findById(id);
    }

    @Override
    public Iterable<T> findAllById(Iterable<ID> ids) {
        return dao.findAllById(ids);
    }

    @Override
    public Iterable<T> findAll() {
        return dao.findAll();
    }

    @Override
    public <S extends T> S update(S entity) {
        return dao.save(entity);
    }

    @Override
    public void deleteById(ID id) {
        dao.deleteById(id);
    }

    @Override
    public void delete(T entity) {
        dao.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<ID> ids) {
        dao.deleteAllById(ids);
    }

    @Override
    public void deleteAll(Iterable<? extends T> entities) {
        dao.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }

}
