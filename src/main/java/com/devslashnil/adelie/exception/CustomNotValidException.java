package com.devslashnil.adelie.exception;


import org.springframework.validation.FieldError;

import java.util.List;

import static java.util.Collections.singletonList;

public class CustomNotValidException extends RuntimeException {

    private final String eventType;
    private final String entityType;
    private final String field;

    public CustomNotValidException(String eventType, String entityType, String field) {
        super();
        this.eventType = eventType;
        this.entityType = entityType;
        this.field = field;
    }

    public FieldError getFieldError() {
        String[] codes = {eventType + "." + field, eventType + "." + entityType + "." + field};
        Object[] arguments = {field};
        return new FieldError(entityType, field, "", false, codes, arguments, "");
    }

    public List<FieldError> getFieldErrors() {
        return singletonList(getFieldError());
    }

    public String getEntityType() {
        return entityType;
    }

}
