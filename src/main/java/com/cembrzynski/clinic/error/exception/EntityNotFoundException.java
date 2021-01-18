package com.cembrzynski.clinic.error.exception;

public class EntityNotFoundException extends Exception implements DescriptionProvider{

    private static final String DESCRIPTION = "Requested entity was not found";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    public EntityNotFoundException() {
        //Should be empty
    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
