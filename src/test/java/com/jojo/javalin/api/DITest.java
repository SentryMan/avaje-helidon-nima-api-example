package com.jojo.javalin.api;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.avaje.http.client.HttpClient;
import io.avaje.inject.test.InjectTest;
import jakarta.inject.Inject;

@InjectTest
class DITest {
  @Inject HttpClient server;

  @Test
  void test() {
    assertEquals(200, server.request().path("nima/health").GET().asString().statusCode());
  }
}
