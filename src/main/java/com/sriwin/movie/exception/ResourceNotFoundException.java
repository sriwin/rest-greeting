package com.sriwin.movie.exception;

public class ResourceNotFoundException extends RuntimeException {
  public ResourceNotFoundException(String errorMsg) {
    super(errorMsg);
  }
}