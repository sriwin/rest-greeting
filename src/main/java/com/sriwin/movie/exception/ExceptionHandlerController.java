package com.sriwin.movie.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
  private static final Class<ExceptionHandlerController> applicationClass = ExceptionHandlerController.class;
  private static final Logger log = LoggerFactory.getLogger(applicationClass);

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ExceptionResponse> resourceNotFound(ResourceNotFoundException e) {
    ExceptionResponse response = new ExceptionResponse();
    response.setErrorCode(HttpStatus.NOT_FOUND.value());
    response.setErrorMessage(e.getMessage());
    return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
  }
}
