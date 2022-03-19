package com.devslashnil.adelie.service;

import com.devslashnil.adelie.dto.UserDTO;

import java.util.Optional;

public interface AccountService {

    Optional<? extends UserDTO.BaseInfo> findByEmail(String email);

}
