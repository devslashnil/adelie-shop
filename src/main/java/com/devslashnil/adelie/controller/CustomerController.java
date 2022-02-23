package com.devslashnil.adelie.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.devslashnil.adelie.exceptions.*;
import com.devslashnil.adelie.model.Customer;
import com.devslashnil.adelie.service.CustomerService;
import com.devslashnil.adelie.util.CustomerInfo;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    public static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Retrieve All Customers
     */
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<JSONObject>> listAllUsers() {
        List<Customer> customer = customerService.findAllCustomers();
        if (customer.isEmpty()) {
            throw new NoContentException("Customers not found.");
        }

        List<JSONObject> customerData = new ArrayList<>();
        CustomerInfo customerInfo = new CustomerInfo();
        for (Customer tempCustomer : customer) {
            customerData.add(customerInfo.getCustomerInfo(tempCustomer));
        }
        return new ResponseEntity<>(customerData, HttpStatus.OK);
    }

    /**
     * Retrieve Single Customer by Id
     */
    @GetMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<JSONObject> getCustomer(@PathVariable("customerId") int customerId) {
        logger.info("Fetching Customer with id {}", customerId);
        Optional<Customer> customer = customerService.findById(customerId);
        if (customer.isEmpty()) {
            throw new CustomerNotFoundException(customerId);
        }

        CustomerInfo customerInfo = new CustomerInfo();
        JSONObject customerData = customerInfo.getCustomerInfo(customer.get());
        return new ResponseEntity<>(customerData, HttpStatus.OK);
    }

    /**
     * Retrieve Single Customer by Email
     */
    @GetMapping("/email={email}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<JSONObject> getCustomerByEmail(@PathVariable("email") String email) {
        logger.info("Fetching Customer with email {}", email);
        Optional<Customer> customer = customerService.findByEmail(email);
        if (customer.isEmpty()) {
            throw new CustomerNotFoundException(email);
        }

        CustomerInfo customerInfo = new CustomerInfo();
        JSONObject customerData = customerInfo.getCustomerInfo(customer.get());
        return new ResponseEntity<>(customerData, HttpStatus.OK);
    }

    /**
     * Create a Customer
     */
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<JSONObject> createCustomer(@RequestBody Customer customer, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Customer : {}", customer);

        System.out.println(customerService.customerExist(customer));

        if (customerService.customerExist(customer)) {
            throw new UnableToCreateCustomerException(customer.getEmail());
        }

        Customer currentCustomer = customerService.createCustomer(customer);
        Integer currentCustomerId = currentCustomer.getId();
        JSONObject customerInfo = new JSONObject();
        customerInfo.put("customerId", currentCustomerId);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/customer/{customerId}").buildAndExpand(customer.getId()).toUri());
        return new ResponseEntity<>(customerInfo, headers, HttpStatus.CREATED);
    }

    /**
     * Update a Customer
     */
    @PutMapping("/{customerId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") int customerId,
                                            @RequestBody Customer customer) {
        logger.info("Updating customer with id {}", customerId);

        Optional<Customer> currentCustomer = customerService.findById(customerId);

        if (currentCustomer.isEmpty()) {
            throw new UnableToUpdateCustomerException(customerId);
        }

        Customer customerForUpdate = currentCustomer.get();
        customerForUpdate.setFirstName(customer.getFirstName());
        customerForUpdate.setLastName(customer.getLastName());
        customerForUpdate.setEmail(customer.getEmail());
        customerForUpdate.setAddress(customer.getAddress());
        customerForUpdate.setPassword(customer.getPassword());

        customerService.updateCustomer(customerForUpdate);
        return new ResponseEntity<>(customerForUpdate, HttpStatus.OK);
    }

    /**
     * Delete a Customer
     */
    @DeleteMapping(value = "/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Customer> deleteCustomer(@PathVariable("customerId") int customerId) {
        logger.info("Fetching & Deleting customer with id {}", customerId);

        Optional<Customer> customer = customerService.findById(customerId);

        if (customer.isEmpty()) {
            throw new UnableToDeleteCustomerException(customerId);
        }

        customerService.deleteCustomerById(customerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
