package com.devslashnil.adelie.repository;

import com.devslashnil.adelie.model.BaseEntity;
import com.devslashnil.adelie.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository<T extends User, ID extends Number> extends CrudRepository<T, ID> {

    Optional<T> findByEmail(String email);

}
