package com.jojo.helidon.api.service;

import com.jojo.helidon.api.client.ApiClient;
import com.jojo.helidon.api.exception.ApplicationException;
import com.jojo.helidon.api.exception.ErrorEnum;
import io.avaje.http.client.HttpException;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import java.net.http.HttpResponse;
import java.util.Optional;

@Singleton
public class ServiceClass {

  private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ServiceClass.class);

  private final ApiClient api;

  @Inject
  public ServiceClass(ApiClient api) {
    this.api = api;
  }

  public byte[] callDownStream() {
    try {

      return api.call("image/png").body();
    } catch (final HttpException e) {
      final var body =
          Optional.ofNullable(e.httpResponse())
              .map(HttpResponse::body)
              .map(byte[].class::cast)
              .map(String::new)
              .orElseGet(e::toString);
      log.info("Failed call because: " + body);
      throw new ApplicationException(ErrorEnum.INTERNAL_ERROR, e);
    }
  }
}
