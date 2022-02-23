package com.devslashnil.adelie.exceptions;

public class UnableToCreateCustomerException extends ControllerException {

    public UnableToCreateCustomerException(String email) {
        super("A customer with email " + email + " already exists.");
    }

}
