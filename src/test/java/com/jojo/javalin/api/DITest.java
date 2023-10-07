package com.jojo.javalin.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.avaje.http.client.HttpClient;
import io.avaje.inject.test.InjectTest;
import io.helidon.webserver.WebServer;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@InjectTest
class DITest {
  @Inject HttpClient server;

  @Test
  void test() {
    assertEquals(200, server.request().path("nima/health").GET().asString().statusCode());
  }
}
