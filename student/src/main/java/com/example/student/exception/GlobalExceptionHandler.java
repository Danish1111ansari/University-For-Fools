package com.example.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {


    // validation error handling
    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity<ApiError> handleEntityValidationException(MethodArgumentNotValidException ex, HttpServletRequest request) {

        String message = ex.getBindingResult()
        .getFieldErrors()
        .get(0)
        .getDefaultMessage();



        ApiError error = new ApiError(
            null, HttpStatus.BAD_REQUEST.value(),
            "Validation Error",
            message,
            request.getRequestURI()

        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
      
    }

    // generc exception handling

    @ExceptionHandler(Exception.class)

    public ResponseEntity<ApiError> handleGenericException(Exception ex, HttpServletRequest request) {

        ApiError error = new ApiError(
            null, HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Internal Server Error",
            ex.getMessage(),
            request.getRequestURI()
        );

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
