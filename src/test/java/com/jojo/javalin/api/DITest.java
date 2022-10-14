package com.jojo.javalin.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.avaje.inject.test.InjectTest;
import io.helidon.nima.webserver.WebServer;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@InjectTest
class DITest {
  @Inject WebServer server;

  @Test
  void test() {
    assertNotNull(server);
  }
}
