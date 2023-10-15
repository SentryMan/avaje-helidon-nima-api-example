package com.jojo.helidon.api.aspect;

import io.avaje.inject.aop.AspectProvider;
import io.avaje.inject.aop.Invocation;
import io.avaje.inject.aop.MethodInterceptor;
import jakarta.inject.Singleton;

import java.lang.reflect.Method;

@Singleton
public class TimedAspect implements AspectProvider<Timed> {

  @Override
  public MethodInterceptor interceptor(Method method, Timed aspectAnnotation) {
    var fullName = method.getName();
    return invocation -> {
      long start = System.nanoTime();
      try {
        invocation.invoke();
      } finally {
        long exeNanos = System.nanoTime() - start;
        System.out.println("executed " + fullName + " in " + exeNanos);
      }
    };
  }
}
