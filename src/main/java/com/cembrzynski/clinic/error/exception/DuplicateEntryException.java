package com.cembrzynski.clinic.error.exception;

public class DuplicateEntryException extends Exception implements DescriptionProvider{

    private static final String DESCRIPTION = "Cannot insert duplicate entry";

    public DuplicateEntryException(String message) {
        super(message);
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
