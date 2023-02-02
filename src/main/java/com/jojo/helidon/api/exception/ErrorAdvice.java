package com.jojo.helidon.api.exception;

import io.helidon.common.http.Http.Status;
import io.helidon.nima.webserver.http.HttpRouting.Builder;
import io.helidon.nima.webserver.http.ServerRequest;
import io.helidon.nima.webserver.http.ServerResponse;
import jakarta.inject.Singleton;

@Singleton
public class ErrorAdvice {
  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ErrorAdvice.class);

  public Builder addErrorHandling(Builder builder) {
    builder.error(Exception.class, this::handle);
    return builder;
  }

  private void handle(ServerRequest req, ServerResponse res, Exception ex) {
    res.status(Status.INTERNAL_SERVER_ERROR_500).send(ex.getMessage());
  }
}
