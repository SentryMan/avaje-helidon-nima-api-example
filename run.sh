#!/usr/bin/env bash
mvn clean package
java --module-path ./target/modules -m nima.example
