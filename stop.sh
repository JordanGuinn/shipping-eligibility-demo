#!/bin/bash

./close-mysql.sh

docker stop shipping-eligibility

docker rm shipping-eligibility
