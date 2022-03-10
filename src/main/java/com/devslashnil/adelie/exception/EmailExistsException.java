package com.devslashnil.adelie.exception;

/**
 * Email Taken
 *
 *
 */
public class EmailExistsException extends CustomNotValidException {

    public EmailExistsException(Class<?> cl) {
        super("Exists", cl.getSimpleName(), "email");
    }

}
