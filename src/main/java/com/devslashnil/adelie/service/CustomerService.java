package com.devslashnil.adelie.service;

import java.util.List;
import java.util.Optional;

import com.devslashnil.adelie.model.Customer;

public interface CustomerService {
    Optional<Customer> findById(Integer customerId);

    Optional<Customer> findByEmail(String email);

    Customer createCustomer(Customer customer);

    void saveCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomerById(Integer customerId);

    void deleteAllCustomers();

    List<Customer> findAllCustomers();

    boolean customerExist(Customer customer);

}
