#!/usr/bin/env bash
mvn clean package
java --module-path ./target/modules -Dconfig.profiles=local --enable-preview -m nima.example
