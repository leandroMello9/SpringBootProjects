package com.validate.validate.exceptions;

import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptions.class);
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(UnprocessingEntityException exception) {
        logger.error(exception.getMethodName().concat(" ".concat(exception.getMessager())));
        return ResponseEntity.status(exception.getStatusCode()).body(exception.getMessager());
    }
}
