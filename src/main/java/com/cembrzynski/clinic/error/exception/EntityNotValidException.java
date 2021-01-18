package com.cembrzynski.clinic.error.exception;

public class EntityNotValidException extends Exception implements DescriptionProvider{

    private static final String DESCRIPTION = "Data was not valid";

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    public EntityNotValidException() {
        //Should be empty
    }

    public EntityNotValidException(String message) {
        super(message);
    }
}
