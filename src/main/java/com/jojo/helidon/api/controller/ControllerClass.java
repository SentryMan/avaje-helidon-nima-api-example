package com.jojo.helidon.api.controller;

import com.jojo.helidon.api.service.ServiceClass;

import io.avaje.http.api.Controller;
import io.avaje.http.api.Get;
import io.avaje.http.api.Path;
import io.avaje.http.api.Post;
import io.avaje.http.api.Produces;
import io.helidon.common.http.HttpMediaType;
import io.helidon.nima.webserver.http.ServerRequest;
import io.helidon.nima.webserver.http.ServerResponse;
import jakarta.inject.Inject;

@Controller
@Path("/nima")
public class ControllerClass {

  private final ServiceClass service;

  @Inject
  public ControllerClass(ServiceClass service) {

    this.service = service;
  }

  @Produces("image/png")
  @Get("/get")
  void test(ServerRequest req, ServerResponse res) {
    res.headers().contentType(HttpMediaType.create("image/png"));

    res.send(service.callDownStream());
  }

  @Post("/post")
  RequestModel testPost(ServerRequest req, ServerResponse res) {

    return new RequestModel("df");
  }

  @Get("/health")
  String health() {

    return "healthlmao";
  }
}
