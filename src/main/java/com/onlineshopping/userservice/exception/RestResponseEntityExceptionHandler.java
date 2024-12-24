package com.onlineshopping.userservice.exception;

import com.onlineshopping.userservice.dto.ApiResponse;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.onlineshopping.userservice.controller.AuthenticationController.ERROR;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    // Handle specific exception
    @ExceptionHandler(UserAlreadyExist.class)
    public ResponseEntity<ApiResponse<Void>> handleResourceNotFoundException(UserAlreadyExist ex) {
        String traceId = MDC.get("traceId");
        ApiResponse<Void> response = new ApiResponse<>(
                ERROR,
                null,
                new ApiResponse.ErrorDetails(HttpStatus.BAD_REQUEST.name(), ex.getMessage()),
                traceId
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(Exception ex) {
        String traceId = MDC.get("traceId");
        ApiResponse<Void> response = new ApiResponse<>(
                ERROR,
                null,
                new ApiResponse.ErrorDetails("INTERNAL_SERVER_ERROR", ex.getMessage()),
                traceId
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
