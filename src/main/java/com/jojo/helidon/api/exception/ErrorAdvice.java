package com.jojo.helidon.api.exception;

import io.helidon.nima.webserver.http.HttpRouting.Builder;
import jakarta.inject.Singleton;

@Singleton
public class ErrorAdvice {
  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ErrorAdvice.class);

  public Builder addErrorHandling(Builder builder) {
    // .addFilter().error(Exception.class, this::handle)
    return builder;
  }

  //  private void handle(ServerRequest req, ServerResponse res, Exception ex) {
  //    res.status(Status.INTERNAL_SERVER_ERROR_500).send(ex.getMessage());
  //  }
}
