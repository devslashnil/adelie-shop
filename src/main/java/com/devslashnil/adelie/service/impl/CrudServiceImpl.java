package com.devslashnil.adelie.service.impl;

import com.devslashnil.adelie.dto.ProductDTO;
import com.devslashnil.adelie.dto.convertor.EntityConvertor;
import com.devslashnil.adelie.exception.NotFoundException;
import com.devslashnil.adelie.model.Product;
import com.devslashnil.adelie.service.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;
import org.springframework.hateoas.RepresentationModel;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Slf4j
public abstract class CrudServiceImpl<T, ID, R extends CrudRepository<T, ID>, DTO extends RepresentationModel<DTO>>
        implements CrudService<ID, DTO> {

    private final R dao;
    private final EntityConvertor<T, DTO> conv;
    private final Class<DTO> classDTO;
    private final Class<? extends T> entityClass;

    protected CrudServiceImpl(R dao, Class<DTO> classDTO, Class<T> entityClass, EntityConvertor<T, DTO> conv) {
        this.dao = dao;
        this.conv = conv;
        this.classDTO = classDTO;
        this.entityClass = entityClass;
    }

    protected abstract DTO addSelfLink(DTO dto);

    protected abstract DTO addListLink(DTO dto);

    @Override
    public DTO create(DTO entityDTO) {
        T entity = conv.convertToEntity(entityDTO, entityClass);
        log.info("Creating {} : {}", entity.getClass().getName(), entity);
        dao.save(entity);
        return addSelfLink(conv.convertToDTO(entity, classDTO));
    }

    @Override
    public DTO findById(ID id) {
        T entity = dao.findById(id).orElseThrow(NotFoundException::new);
        log.info("Fetching {} with id {} : {}", entity.getClass().getName(), id, entity);
        return addSelfLink(conv.convertToDTO(entity, classDTO));
    }

    @Override
    public List<DTO> findAllById(Iterable<ID> ids) {
        List<DTO> entities = conv.convertToDTO(dao.findAllById(ids), classDTO).stream()
                .map(this::addSelfLink)
                .map(this::addListLink)
                .collect(Collectors.toList());
        log.info("Fetching entities of {} with ids {} : {}", "#sometype", ids, entities);
        return entities;
    }

    @Override
    public List<DTO> findAll() {
        List<DTO> entities = conv.convertToDTO(dao.findAll(), classDTO).stream()
                .map(this::addSelfLink)
                .map(this::addListLink)
                .collect(Collectors.toList());
        log.info("Fetching all entities of {}", "#sometype");
        return entities;
    }

    @Override
    public DTO update(DTO entityDTO) {
        T entity = conv.convertToEntity(entityDTO, entityClass);
        log.info("Updating {} : {}", entity.getClass().getName(), entity);
        return addSelfLink(conv.convertToDTO(dao.save(entity), classDTO));
    }

    @Override
    public void deleteById(ID id) {
        log.info("Deleting entity by id : {}", id);
        dao.deleteById(id);
    }

    @Override
    public void delete(DTO entityDTO) {
        T entity = conv.convertToEntity(entityDTO, entityClass);
        log.info("Deleting {} : {}", entity.getClass().getName(), entity);
        dao.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<ID> ids) {
        log.info("Deleting entities by ids {}", ids);
        dao.deleteAllById(ids);
    }

    // Out of implementation for now
//    @Override
//    public void deleteAll(Iterable<? extends DTO> entities) {
//        log.info("Deleting all entities : {}", entities);
//        dao.deleteAll(entities);
//    }

    @Override
    public void deleteAll() {
        log.info("Deleting all entities");
        dao.deleteAll();
    }

}
