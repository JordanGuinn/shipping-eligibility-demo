#!/bin/bash

# Start up MySQL in a separate container
./open-mysql.sh

# We need to properly spin up our database and users before spinning up the application consuming it
printf "And now we wait...\n"
for i in {01..18}; do
    sleep 1
    let seconds=20-$i
    printf "$seconds seconds left\n"

done

printf "Building Spring Boot container next..."
# Build Docker image for shipping-eligibility project
docker build -t shipping-eligibility .

# Start it up!
docker run --name shipping-eligibility -d --link shipping-eligibility-mysql-server:ebay-db -p 3314:8080 shipping-eligibility
