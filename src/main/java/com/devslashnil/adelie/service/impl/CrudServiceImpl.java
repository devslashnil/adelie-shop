package com.devslashnil.adelie.service.impl;

import com.devslashnil.adelie.exception.NoContentException;
import com.devslashnil.adelie.service.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;

@Slf4j
public abstract class CrudServiceImpl<T, ID, R extends CrudRepository<T, ID>>
        implements CrudService<T,ID> {

    private final R dao;

    protected CrudServiceImpl(R dao) {
        this.dao = dao;
    }

    @Override
    public <S extends T> S create(S entity) {
        log.info("Creating {} : {}", entity.getClass().getName(), entity);
        return dao.save(entity);
    }

    @Override
    public T findById(ID id) {
        T entity = dao.findById(id).orElseThrow(NoContentException::new);
        log.info("Fetching {} with id {} : {}", entity.getClass().getName(), id, entity);
        return entity;
    }

    @Override
    public Iterable<T> findAllById(Iterable<ID> ids) {
        Iterable<T> entities = dao.findAllById(ids);
        log.info("Fetching entities of {} with ids {} : {}", "#sometype", ids, entities);
        return entities;
    }

    @Override
    public Iterable<T> findAll() {
        log.info("Fetching all entities of {}", "#sometype");
        return dao.findAll();
    }

    @Override
    public <S extends T> S update(S entity) {
        log.info("Updating {} : {}", entity.getClass().getName(), entity);
        return dao.save(entity);
    }

    @Override
    public void deleteById(ID id) {
        log.info("Deleting entity by id : {}", id);
        dao.deleteById(id);
    }

    @Override
    public void delete(T entity) {
        log.info("Deleting {} : {}", entity.getClass().getName(), entity);
        dao.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<ID> ids) {
        log.info("Deleting entities by ids {}", ids);
        dao.deleteAllById(ids);
    }

    @Override
    public void deleteAll(Iterable<? extends T> entities) {
        log.info("Deleting all entities : {}", entities);
        dao.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        log.info("Deleting all entities");
        dao.deleteAll();
    }

}
