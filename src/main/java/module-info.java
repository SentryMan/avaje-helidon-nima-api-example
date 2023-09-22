module nima.example {

  requires io.avaje.nima;
  requires io.avaje.http.client;
  requires io.avaje.validation.http;
  requires java.naming;
  requires io.avaje.logback.encoder;

  provides io.avaje.inject.spi.Module with
      com.jojo.helidon.api.ApiModule;
  provides io.avaje.http.client.HttpClient.GeneratedComponent with
      com.jojo.helidon.api.client.httpclient.GeneratedHttpComponent;
  provides io.avaje.jsonb.Jsonb.GeneratedComponent with
      com.jojo.helidon.api.jsonb.GeneratedJsonComponent;
}
