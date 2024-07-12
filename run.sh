#!/usr/bin/env bash

if ! test -f opentelemetry-javaagent.jar; then
  curl -L -O https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/latest/download/opentelemetry-javaagent.jar
fi

export OTEL_EXPORTER_OTLP_ENDPOINT=https://otlp.nr-data.net
export OTEL_EXPORTER_OTLP_HEADERS=api-key=<nr-license-key-goes-here>
export OTEL_ATTRIBUTE_VALUE_LENGTH_LIMIT=4095
export OTEL_EXPORTER_OTLP_METRICS_TEMPORALITY_PREFERENCE=DELTA
export OTEL_EXPERIMENTAL_EXPORTER_OTLP_RETRY_ENABLED=true
export OTEL_EXPORTER_OTLP_METRICS_DEFAULT_HISTOGRAM_AGGREGATION=BASE2_EXPONENTIAL_BUCKET_HISTOGRAM
export OTEL_EXPORTER_OTLP_COMPRESSION=gzip
export OTEL_SERVICE_NAME=helidon-apm-test
export OTEL_EXPERIMENTAL_RESOURCE_DISABLED_KEYS=process.command_args
mvn clean package
java -javaagent:opentelemetry-javaagent.jar --module-path ./target/modules -Dconfig.profiles=local -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005 --enable-preview -m nima.example/com.jojo.helidon.api.NimaAPI
