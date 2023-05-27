package com.jojo.helidon.api.config;

import io.avaje.config.Config;
import io.avaje.inject.Bean;
import io.avaje.inject.Factory;
import io.helidon.nima.webserver.WebServer;
import io.helidon.nima.webserver.http.HttpRouting;
import io.helidon.nima.webserver.http.HttpService;
import java.util.List;

@Factory
public class ServerFactory {

  @Bean
  WebServer server(List<HttpService> routes) {

    final var builder = HttpRouting.builder();
    for (final HttpService httpService : routes) {
      httpService.routing(builder);
    }

    builder.addFilter(
        (x, y, z) -> {
          x.proceed();
        });
    return WebServer.builder().addRouting(builder).port(Config.getInt("server.port", 8080)).build();
  }
}
