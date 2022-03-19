package com.devslashnil.adelie.service.impl;

import com.devslashnil.adelie.dto.BaseDTO;
import com.devslashnil.adelie.dto.convertor.DataConvertor;
import com.devslashnil.adelie.model.User;
import com.devslashnil.adelie.repository.UserRepository;
import com.devslashnil.adelie.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.RepresentationModel;

import java.util.Optional;

@Slf4j
public abstract class UserServiceImpl<T extends User, ID extends Number,
        R extends UserRepository<T, ID>, DTO extends RepresentationModel<DTO> & BaseDTO>
        extends CrudServiceImpl<T, ID, R, DTO> implements UserService<ID, DTO> {

    protected UserServiceImpl(R dao, Class<DTO> classDTO, Class<T> entityClass, DataConvertor<T, DTO> conv) {
        super(dao, classDTO, entityClass, conv);
    }

    @Override
    public Optional<DTO> findByEmail(String email) {
        Optional<T> entity = dao.findByEmail(email);
        log.info("Fetching {} : {}", entity.getClass().getName(), entity);
        return entity.map((e) -> conv.convertToDTO(e, classDTO))
                .map(this::addSelfLink);
    }

}
