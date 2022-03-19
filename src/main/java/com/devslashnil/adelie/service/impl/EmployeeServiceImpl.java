package com.devslashnil.adelie.service.impl;

import com.devslashnil.adelie.dto.EmployeeDTO;
import com.devslashnil.adelie.dto.UserDTO;
import com.devslashnil.adelie.dto.convertor.DataConvertor;
import com.devslashnil.adelie.model.Employee;
import com.devslashnil.adelie.repository.EmployeeRepository;
import com.devslashnil.adelie.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmployeeServiceImpl extends UserServiceImpl<Employee, Integer, EmployeeRepository,
        UserDTO.Response.Employee> implements EmployeeService {

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository dao, DataConvertor<Employee, UserDTO.Response.Employee> conv) {
        super(dao, UserDTO.Response.Employee.class, Employee.class, conv);
    }

}
