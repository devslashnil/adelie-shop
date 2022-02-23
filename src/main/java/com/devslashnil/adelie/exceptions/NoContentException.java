package com.devslashnil.adelie.exceptions;

public class NoContentException extends ControllerException {

    public NoContentException() {
        super("Content not found.");
    }

    public NoContentException(String message) {
        super(message);
    }

}
