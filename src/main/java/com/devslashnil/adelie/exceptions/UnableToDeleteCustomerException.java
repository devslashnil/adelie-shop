package com.devslashnil.adelie.exceptions;

public class UnableToDeleteCustomerException extends ControllerException {

    public UnableToDeleteCustomerException(int customerId) {
        super("Unable to delete. Customer with id " + customerId + " not found.");
    }

}
