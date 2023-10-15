package com.jojo.helidon.api.exception;

import io.avaje.http.api.Controller;
import io.avaje.http.api.ExceptionHandler;
import io.avaje.http.api.ValidationException;

@Controller
public class ErrorAdvice {

  @ExceptionHandler
  public ErrorResponse handle(Exception ex) {
    return new ErrorResponse("5000", ex.getMessage());
  }

  @ExceptionHandler(statusCode = 400)
  public ErrorResponse validationError(ValidationException ex) {
    return new ErrorResponse("4000", ex.getMessage());
  }
}
