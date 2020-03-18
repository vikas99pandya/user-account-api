package com.ing.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for user product micro-service
 */
@ControllerAdvice
public class UserProdExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(UserProdExceptionHandler.class);

    @ExceptionHandler(value = UserProductException.class)
    public ResponseEntity<Object> exception(UserProductException userProductException) {
        LOG.error("application processing error occured",userProductException);
        return new ResponseEntity<>(userProductException.getErrorCode(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<Object> exception(RuntimeException exception) {
        LOG.error("application run time error occured",exception);
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
