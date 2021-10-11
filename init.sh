#!/bin/bash
cd devtest/
mvn clean install
cd ..
docker-compose up -d simulado influxdb grafana spring-boot-app
docker-compose run --rm k6 run scripts/test.js