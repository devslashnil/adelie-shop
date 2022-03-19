package com.devslashnil.adelie.service.impl;

import com.devslashnil.adelie.dto.UserDTO;
import com.devslashnil.adelie.service.AccountService;
import com.devslashnil.adelie.service.CustomerService;
import com.devslashnil.adelie.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public record AccountServiceImpl(CustomerService customerService,
                                 EmployeeService employeeService) implements AccountService {

    @Autowired
    public AccountServiceImpl {
    }

    public Optional<? extends UserDTO.BaseInfo> findByEmail(String email) {
        Optional<UserDTO.Response.Customer> customerDTO = customerService.findByEmail(email);
        if (customerDTO.isPresent()) {
            return customerDTO;
        }
        return employeeService.findByEmail(email);
    }

}
