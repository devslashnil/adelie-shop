package com.devslashnil.adelie.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super();
    }

    public NotFoundException(int id) {
        super("Entity  with id " + id + " not found.");
    }

}
