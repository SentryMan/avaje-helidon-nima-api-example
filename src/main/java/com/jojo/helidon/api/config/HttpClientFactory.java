package com.jojo.helidon.api.config;

import com.jojo.helidon.api.client.HTTPListeners;
import io.avaje.config.Config;
import io.avaje.http.client.HttpClientContext;
import io.avaje.http.client.JsonbBodyAdapter;
import io.avaje.inject.Bean;
import io.avaje.inject.Factory;
import io.avaje.jsonb.Jsonb;
import java.net.http.HttpClient.Version;
import java.time.Duration;
import java.util.concurrent.Executors;

@Factory
public class HttpClientFactory {

  @Bean
  HttpClientContext client(
      // AuthProvider provider
      Jsonb jsonb) {

    return HttpClientContext.builder()
        .baseUrl(Config.get("base.url"))
        .bodyAdapter(new JsonbBodyAdapter(jsonb))
        .executor(Executors.newVirtualThreadPerTaskExecutor())
        //     .authTokenProvider(provider)
        .requestTimeout(Duration.ofMillis(Config.getLong("timeout", 5000)))
        .retryHandler(HTTPListeners::retryHandler)
        .version(Version.HTTP_1_1)
        // disable native requestlogging in favor of custom one
        .requestLogging(false)
        .requestListener(HTTPListeners::logRequest)
        .build();
  }
}
