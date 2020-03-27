#!/bin/bash
# Spin down and remove MySQL container
docker stop shipping-eligibility-mysql-server

docker rm shipping-eligibility-mysql-server
