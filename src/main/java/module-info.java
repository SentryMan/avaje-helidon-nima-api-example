module nima.example {
  requires io.avaje.inject;
  requires io.avaje.config;
  requires io.avaje.http.client;
  requires io.avaje.jsonb.plugin;
  requires io.helidon.webserver;
  requires io.avaje.http.api;
  requires org.slf4j;

  provides io.avaje.inject.spi.Module with
      com.jojo.helidon.api.ApiModule;
  provides io.avaje.http.client.HttpClient.GeneratedComponent with
      com.jojo.helidon.api.client.httpclient.GeneratedHttpComponent;
  provides io.avaje.jsonb.Jsonb.GeneratedComponent with
      com.jojo.helidon.api.jsonb.GeneratedJsonComponent;
}
