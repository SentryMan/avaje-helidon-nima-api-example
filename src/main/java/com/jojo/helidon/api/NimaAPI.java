package com.jojo.helidon.api;

import io.avaje.inject.BeanScope;
import io.helidon.webserver.WebServer;

public class NimaAPI {

  public static void main(String[] args) {

    try {
      BeanScope.builder().build().get(WebServer.class).start();

    } catch (final Exception e) {
      e.printStackTrace();
    }
  }
}
