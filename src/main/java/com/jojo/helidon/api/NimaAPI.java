package com.jojo.helidon.api;

import org.slf4j.LoggerFactory;

import io.avaje.nima.Nima;

public class NimaAPI {

  public static void main(String[] args) {
    try {

      Nima.builder().build().start();

    } catch (final Exception e) {
      e.printStackTrace();
    }
  }
}
