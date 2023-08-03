package com.jojo.helidon.api.config;

import io.avaje.config.Config;
import io.avaje.inject.Bean;
import io.avaje.inject.Factory;
import io.helidon.nima.webserver.WebServer;
import io.helidon.nima.webserver.http.HttpFeature;
import io.helidon.nima.webserver.http.HttpRouting;
import java.util.List;

@Factory
public class ServerFactory {

  @Bean
  WebServer server(List<HttpFeature> routes) {

    final var builder = HttpRouting.builder();

    routes.forEach(builder::addFeature);

    return WebServer.builder()
        .addRouting(builder.build())
        .port(Config.getInt("server.port", 8080))
        .build();
  }
}
