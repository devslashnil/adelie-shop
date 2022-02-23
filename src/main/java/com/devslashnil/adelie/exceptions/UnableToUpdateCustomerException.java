package com.devslashnil.adelie.exceptions;

public class UnableToUpdateCustomerException extends ControllerException {

    public UnableToUpdateCustomerException(int customerId) {
        super("Unable to update. Customer with id " + customerId + " not found.");
    }

}
