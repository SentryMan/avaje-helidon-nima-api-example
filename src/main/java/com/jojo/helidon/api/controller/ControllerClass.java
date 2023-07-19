package com.jojo.helidon.api.controller;

import com.jojo.helidon.api.service.ServiceClass;
import io.avaje.http.api.Controller;
import io.avaje.http.api.Get;
import io.avaje.http.api.Post;
import io.avaje.http.api.Produces;
import io.helidon.nima.webserver.http.ServerRequest;
import io.helidon.nima.webserver.http.ServerResponse;
import jakarta.inject.Inject;
import java.io.InputStream;
import java.util.List;

@Controller("/nima")
public class ControllerClass {

  private final ServiceClass service;

  @Inject
  public ControllerClass(ServiceClass service) {

    this.service = service;
  }

  @Produces("image/png")
  @Get("/get")
  InputStream testBytes(ServerRequest req, ServerResponse res) {
    req.headers().first(io.helidon.common.http.Http.Header.create(""));
    return service.callDownStream();
  }

  @Post("/post")
  RequestModel testPost(RequestModel m) {

    return new RequestModel("dfdf");
  }

  @Post("/postList")
  List<RequestModel> testList(List<RequestModel> l) {

    return List.of(new RequestModel("df"));
  }

  @Get("/health")
  String health() {

    return "healthlmao";
  }
}
