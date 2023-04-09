package com.jojo.helidon.api.exception;

import io.avaje.jsonb.JsonType;
import io.avaje.jsonb.Jsonb;
import io.avaje.jsonb.stream.JsonOutput;
import io.helidon.common.http.Http.Status;
import io.helidon.nima.webserver.http.HttpRouting.Builder;
import io.helidon.nima.webserver.http.HttpRules;
import io.helidon.nima.webserver.http.HttpService;
import io.helidon.nima.webserver.http.ServerRequest;
import io.helidon.nima.webserver.http.ServerResponse;
import jakarta.inject.Singleton;

@Singleton
public class ErrorAdvice implements HttpService {

  private final JsonType<ErrorResponse> errorType;

  ErrorAdvice(Jsonb jsonb) {
    this.errorType = jsonb.type(ErrorResponse.class);
  }

  // register the different error handling
  @Override
  public void routing(HttpRules rules) {
    if (rules instanceof final Builder builder) {
      builder.error(Exception.class, this::handle);
    }
  }

  private void handle(ServerRequest req, ServerResponse res, Exception ex) {
    final var outputStream = getServletStream(Status.INTERNAL_SERVER_ERROR_500, res);
    final var error = new ErrorResponse("5000", ex.getMessage());
    errorType.toJson(error, outputStream);
  }

  JsonOutput getServletStream(Status status, ServerResponse res) {

    return JsonOutput.of(res.status(status).header("Content-Type", "application/json"));
  }
}
