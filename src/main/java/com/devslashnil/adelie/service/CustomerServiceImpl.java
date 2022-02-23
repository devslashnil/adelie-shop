package com.devslashnil.adelie.service;


import java.util.List;
import java.util.Optional;

import com.devslashnil.adelie.model.Customer;
import com.devslashnil.adelie.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Optional<Customer> findById(Integer customerId) {
        return customerRepository.findById(customerId);
    }

    public Optional<Customer> findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public Customer createCustomer(Customer customer) {
        customer = customerRepository.save(customer);
        // TASK: flush isn't defined, don't know possible pitfalls
        // customerRepository.flush();
        return customer;
    }

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteAllCustomers() {
        customerRepository.deleteAll();
    }

    public List<Customer> findAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    public boolean customerExist(Customer customer) {
        System.out.println(customer.getEmail());
        return customerRepository.findByEmail(customer.getEmail()).isPresent();
    }

    public void deleteCustomerById(Integer customerId) {
        customerRepository.deleteById(customerId);
    }

}
