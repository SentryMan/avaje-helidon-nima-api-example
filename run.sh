#!/usr/bin/env bash
mvn clean package
java --module-path ./target/modules -Dconfig.profiles=local -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005 --enable-preview -m nima.example/com.jojo.helidon.api.NimaAPI
