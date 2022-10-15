package com.jojo.helidon.api.controller;

import com.jojo.helidon.api.service.ServiceClass;
import io.avaje.http.api.Controller;
import io.avaje.http.api.Get;
import io.avaje.http.api.Path;
import io.avaje.http.api.Post;
import io.avaje.http.api.Produces;
import io.helidon.nima.webserver.http.ServerRequest;
import io.helidon.nima.webserver.http.ServerResponse;
import jakarta.inject.Inject;
import java.util.List;

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
  byte[] testBytes(ServerRequest req, ServerResponse res) {
    return service.callDownStream();
  }

  @Post("/post")
  RequestModel testPost(ServerRequest req, ServerResponse res) {

    return new RequestModel("df");
  }

  @Post("/postList")
  List<RequestModel> testList(ServerRequest req, ServerResponse res) {

    return List.of(new RequestModel("df"));
  }

  @Get("/health")
  String health() {

    return "healthlmao";
  }
}
