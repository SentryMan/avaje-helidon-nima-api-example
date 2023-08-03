package com.jojo.helidon.api.exception;

import io.avaje.http.api.Controller;
import io.avaje.http.api.ExceptionHandler;

@Controller
public class ErrorAdvice {

  @ExceptionHandler
  public ErrorResponse handle(Exception ex) {
    return new ErrorResponse("5000", ex.getMessage());
  }
}
