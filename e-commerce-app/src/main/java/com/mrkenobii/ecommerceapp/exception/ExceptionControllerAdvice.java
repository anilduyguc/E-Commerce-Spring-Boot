package com.mrkenobii.ecommerceapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(value = CustomException.class)
    public final ResponseEntity<String> handleCustomException(CustomException customException){
        return new ResponseEntity<>(customException.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = AuthenticationFailedException.class)
    public final ResponseEntity<String> handleAuthenticationFailedException(AuthenticationFailedException authenticationFailedException){
        return new ResponseEntity<>(authenticationFailedException.getMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = ProductNotExistException.class)
    public final ResponseEntity<String> handleProductNotExistException(ProductNotExistException productNotExistException){
        return new ResponseEntity<>(productNotExistException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
