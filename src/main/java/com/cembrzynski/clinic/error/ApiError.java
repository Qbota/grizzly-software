package com.cembrzynski.clinic.error;

import com.cembrzynski.clinic.error.exception.DescriptionProvider;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ApiError {

    private HttpStatus httpStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message = "Unexpected error";
    private String debugMessage;

    private ApiError() {
        timestamp = LocalDateTime.now();
    }
    public ApiError(HttpStatus httpStatus, DescriptionProvider descriptionProvider, Exception ex) {
        this();
        this.httpStatus = httpStatus;
        this.message = descriptionProvider.getDescription();
        this.debugMessage = ex.getLocalizedMessage();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

}
