#!/bin/bash
mvn clean
mvn package
docker-compose build
docker-compose up