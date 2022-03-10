package com.devslashnil.adelie.service.impl;

import com.devslashnil.adelie.dto.convertor.ConvertorToDTO;
import com.devslashnil.adelie.exception.NotFoundException;
import com.devslashnil.adelie.service.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;
import org.springframework.hateoas.RepresentationModel;

@Slf4j
public abstract class CrudServiceImpl<T, ID, R extends CrudRepository<T, ID>, DTO extends RepresentationModel<DTO>,
        C extends ConvertorToDTO<T, DTO>> implements CrudService<T,ID, DTO> {

    private final R dao;
    private final C conv;

    protected CrudServiceImpl(R dao, C conv) {
        this.dao = dao;
        this.conv = conv;
    }

    @Override
    public <S extends T> DTO create(S entity) {
        log.info("Creating {} : {}", entity.getClass().getName(), entity);
        dao.save(entity);
        return conv.convertToDTO(entity);
    }

    @Override
    public DTO findById(ID id) {
        T entity = dao.findById(id).orElseThrow(NotFoundException::new);
        log.info("Fetching {} with id {} : {}", entity.getClass().getName(), id, entity);
        return conv.convertToDTO(entity);
    }

    @Override
    public Iterable<DTO> findAllById(Iterable<ID> ids) {
        Iterable<T> entities = dao.findAllById(ids);
        log.info("Fetching entities of {} with ids {} : {}", "#sometype", ids, entities);
        return conv.convertToDTO(entities);
    }

    @Override
    public Iterable<DTO> findAll() {
        log.info("Fetching all entities of {}", "#sometype");
        Iterable<T> entities = dao.findAll();
        return conv.convertToDTO(entities);
    }

    @Override
    public <S extends T> DTO update(S entity) {
        log.info("Updating {} : {}", entity.getClass().getName(), entity);
        return conv.convertToDTO(dao.save(entity));
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
