package com.jojo.helidon.api.client;

import io.avaje.http.api.Client;
import io.avaje.http.api.Get;
import io.avaje.http.api.Header;
import io.avaje.http.api.Headers;

import java.io.InputStream;
import java.net.http.HttpResponse;

@Client
public interface ApiClient {
  @Get("/images?q=tbn:ANd9GcTGdTHmcbadka3hCrTy52J0z7Jur5maarnmjZMa0XYnnJjtBBMj")
  @Headers("Accept: image/jpeg")
  HttpResponse<InputStream> call();
}
