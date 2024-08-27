module nima.example {

  requires io.avaje.nima;
  requires jakarta.inject;
  requires io.avaje.inject.aop;
  requires io.avaje.http.client;
  requires io.avaje.validation.contraints;
  requires io.avaje.validation.http;
  requires io.avaje.logback.encoder;

  provides io.avaje.inject.spi.InjectExtension with
      com.jojo.helidon.api.ApiModule;
  provides io.avaje.http.client.HttpClient.GeneratedComponent with
      com.jojo.helidon.api.client.httpclient.GeneratedHttpComponent;
  provides io.avaje.jsonb.spi.JsonbExtension with
      com.jojo.helidon.api.jsonb.GeneratedJsonComponent;
  provides io.avaje.validation.spi.ValidationExtension with
      com.jojo.helidon.api.controller.valid.GeneratedValidatorComponent;
}
