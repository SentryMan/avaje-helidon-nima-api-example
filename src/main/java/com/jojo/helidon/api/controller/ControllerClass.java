package com.jojo.helidon.api.controller;

import java.io.InputStream;
import java.util.List;

import com.jojo.helidon.api.service.ServiceClass;

import io.avaje.http.api.Controller;
import io.avaje.http.api.Get;
import io.avaje.http.api.Post;
import io.avaje.http.api.Produces;
import io.helidon.webserver.http.ServerRequest;
import io.helidon.webserver.http.ServerResponse;
import jakarta.inject.Inject;

@Controller("/nima")
public class ControllerClass {

  private final ServiceClass service;

  @Inject
  public ControllerClass(ServiceClass service) {

    this.service = service;
  }

  @MyTimed
  @Produces("image/png")
  @Get("/get")
  InputStream testBytes(ServerRequest req, ServerResponse res) {

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
