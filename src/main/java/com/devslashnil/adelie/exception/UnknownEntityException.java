package com.devslashnil.adelie.exception;

public class UnknownEntityException extends CustomNotValidException {

    private final String idField;
    private final long idValue;

    public UnknownEntityException(Class<?> cl, long idValue) {
        this(cl, "id", idValue);
    }

    public UnknownEntityException(Class<?> cl, String idField, long idValue) {
        super("NotExist", cl.getSimpleName(), idField);
        this.idField = idField;
        this.idValue = idValue;
    }

    public String getIdField() {
        return idField;
    }

    public long getIdValue() {
        return idValue;
    }

}
