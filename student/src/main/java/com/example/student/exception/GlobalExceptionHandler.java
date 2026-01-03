package com.example.student.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.student.response.ApiResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {


    // validation error handling
    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity<ApiResponse<?>> handleEntityValidationException(MethodArgumentNotValidException ex, HttpServletRequest request) {

       List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .toList();

        ApiResponse<?> response = ApiResponse.failure(
                HttpStatus.BAD_REQUEST.value(),
                "Validation Error",
                errors,
                request.getRequestURI()
        );

        return ResponseEntity.badRequest().body(response);
      
    }

    // generc exception handling

    @ExceptionHandler(Exception.class)

    public ResponseEntity<ApiResponse<?>> handleGenericException(Exception ex, HttpServletRequest request) {

        ApiResponse<?> response = ApiResponse.failure(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Internal Server Error",
            ex.getMessage(),
            request.getRequestURI()
        );

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }



}
