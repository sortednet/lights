#!/bin/bash -eux

echo "Waiting for the DB to start - must find a better way than sleeping"

sleep 20

java -jar lights-webserver.jar