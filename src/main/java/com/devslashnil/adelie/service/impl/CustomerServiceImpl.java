package com.devslashnil.adelie.service.impl;

import com.devslashnil.adelie.dto.CustomerDTO;
import com.devslashnil.adelie.dto.UserDTO;
import com.devslashnil.adelie.dto.convertor.DataConvertor;
import com.devslashnil.adelie.model.Customer;
import com.devslashnil.adelie.repository.CustomerRepository;
import com.devslashnil.adelie.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerServiceImpl extends UserServiceImpl<Customer, Integer, CustomerRepository,
        UserDTO.Response.Customer> implements CustomerService {

    @Autowired
    public CustomerServiceImpl(CustomerRepository dao, DataConvertor<Customer, UserDTO.Response.Customer> conv) {
        super(dao, UserDTO.Response.Customer.class, Customer.class, conv);
    }

}
