package com.jojo.helidon.api.config;

import com.jojo.helidon.api.exception.ErrorAdvice;
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
  WebServer server(List<HttpService> routes, ErrorAdvice advice) {

    final var builder = HttpRouting.builder();
    for (final HttpService httpService : routes) {
      httpService.routing(builder);
    }

    return WebServer.builder()
        .addRouting(advice.addErrorHandling(builder))
        .port(Config.getInt("server.port", 8080))
        .build();
  }
}
