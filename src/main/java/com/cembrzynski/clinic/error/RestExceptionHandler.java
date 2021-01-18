package com.cembrzynski.clinic.error;

import com.cembrzynski.clinic.error.exception.AuthenticationException;
import com.cembrzynski.clinic.error.exception.EntityNotFoundException;
import com.cembrzynski.clinic.error.exception.EntityNotValidException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex){
        var apiError = new ApiError(HttpStatus.NOT_FOUND, ex, ex);
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityNotValidException.class)
    protected ResponseEntity<Object> handleEntityNotValid(EntityNotValidException ex){
        var apiError = new ApiError(HttpStatus.BAD_REQUEST, ex, ex);
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(AuthenticationException.class)
    protected ResponseEntity<Object> handleAuthenticationException(AuthenticationException ex){
        var apiError = new ApiError(HttpStatus.UNAUTHORIZED, ex, ex);
        return new ResponseEntity<>(apiError, HttpStatus.UNAUTHORIZED);
    }
}
