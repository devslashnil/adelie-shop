package com.devslashnil.adelie.exceptions;

public class CustomerNotFoundException extends ControllerException {

    public CustomerNotFoundException(int customerId) {
        super("Customer with id " + customerId + " not found");
    }

    public CustomerNotFoundException(String email) {
        super("Customer with id " + email + " not found");
    }
}
