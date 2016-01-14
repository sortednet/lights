#!/bin/bash -eux

echo "Waiting for the DB to start - must find a better way than sleeping"

sleep 20

ping -c 1 lights-db.sorted.net

java -jar lights-webserver.jar
