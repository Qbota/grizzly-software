package com.cembrzynski.clinic.error.exception;

public class AuthenticationException extends Exception implements DescriptionProvider{

    private static final String DESCRIPTION = "Authentication error";

    public AuthenticationException(String message) {
        super(message);
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
