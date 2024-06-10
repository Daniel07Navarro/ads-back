package com.ads.adsback.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> allExceptionHandler(Exception ex, WebRequest req) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .dateTime(LocalDateTime.now())
                .message(ex.getMessage())
                .path(req.getDescription(false))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> validationExceptionHandler(ValidationException ex,WebRequest req){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .dateTime(LocalDateTime.now())
                .message(ex.getMessage())
                .path(req.getDescription(false))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(ModelNotFount.class)
    public ResponseEntity<?> modelNotFountException(ModelNotFount ex, WebRequest req) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .dateTime(LocalDateTime.now())
                .message(ex.getMessage())
                .path(req.getDescription(false))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<?> sqlException(SQLException ex, WebRequest req) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .dateTime(LocalDateTime.now())
                .message(ex.getMessage())
                .path(req.getDescription(false))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .dateTime(LocalDateTime.now())
                .message(ex.getMessage())
                .path(request.getDescription(false))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String message = ex.getFieldErrors()
                .stream()
                .map(e -> e.getField() + " ; " + e.getDefaultMessage())
                .collect(Collectors.joining(";"));
        ErrorResponse errorResponse = ErrorResponse.builder()
                .dateTime(LocalDateTime.now())
                .message(message)
                .path(request.getDescription(false))
                .build();
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
