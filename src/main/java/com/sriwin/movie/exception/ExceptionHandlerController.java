package com.sriwin.movie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException e) {
    ExceptionResponse response = new ExceptionResponse();
    response.setErrorCode(HttpStatus.NOT_FOUND.value());
    response.setErrorMessage(e.getMessage());
    return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
  }
}
