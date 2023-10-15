package com.jojo.helidon.api.controller;

import io.avaje.http.api.Valid;
import io.avaje.jsonb.Json;
import io.avaje.validation.constraints.NotBlank;

@Json
@Valid
public record RequestModel(@NotBlank(message = "{10001}") String value) {}
