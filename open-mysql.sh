#!/bin/bash

printf "Pulling down Docker container for MySQL 5.7...\n"
docker pull mysql:5.7

printf "Contained retrieved!  Executing now...\n"
docker run -p 6603:3306 --name=shipping-eligibility-mysql-server \
    -e MYSQL_ROOT_PASSWORD=84jkldslur203k \
    -e MYSQL_USER=testUser \
    -e MYSQL_PASSWORD=testPassword \
    -e MYSQL_DATABASE=ebay \
    -d mysql
