module nima.example {

  requires io.avaje.nima;
  requires java.instrument;
  requires io.helidon.tracing;
  requires io.helidon.webserver.observe;
  requires io.helidon.webserver.observe.tracing;
  requires io.avaje.http.client;
  requires io.avaje.validation.contraints;
  requires io.avaje.validation.http;
  requires io.avaje.logback.encoder;

  provides io.avaje.inject.spi.Module with
      com.jojo.helidon.api.ApiModule;
  provides io.avaje.http.client.HttpClient.GeneratedComponent with
      com.jojo.helidon.api.client.httpclient.GeneratedHttpComponent;
  provides io.avaje.jsonb.Jsonb.GeneratedComponent with
      com.jojo.helidon.api.jsonb.GeneratedJsonComponent;
  provides io.avaje.validation.Validator.GeneratedComponent with
      com.jojo.helidon.api.controller.valid.GeneratedValidatorComponent;
}
