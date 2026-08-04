package com.jojo.helidon.api;

import io.avaje.inject.Profile;
import jakarta.inject.Singleton;

@Singleton
@Profile(none = "cloud")
public class LocalService implements MyService { }

