package com.phaete.nf412recapspringboot;

import com.phaete.nf412recapspringboot.model.ErrorMessage;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ErrorMessage handleAllUncaughtExceptions(Exception e) {
        return new ErrorMessage(e.getClass().getName(), "Could not complete request.\n" + e.getMessage());
    }
}
