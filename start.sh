#!/bin/bash

set -e  #Stop the script if any command fails

echo "Step 1: Compiling the application with Maven..."
mvn clean package -DskipTests

echo "Application compiled successfully."

echo "Step 2: Building the Docker image..."
docker compose build

echo "Docker image built successfully."

echo "Step 3: Starting the containers with Docker Compose..."
docker compose up -d

echo "Waiting for PostgreSQL to be ready..."
until docker exec hospital_db pg_isready -U admin -d hospital; do
    echo "PostgreSQL is not ready yet, waiting..."
    sleep 2
done

echo "PostgreSQL is ready."

echo "Step 4: Checking database tables..."
docker exec -i hospital_db psql -U admin -d hospital -c "\dt"

echo "Database tables checked"

echo "Step 5: Checking Flyway migrations..."
docker logs hospital_app | grep "Flyway"

echo "Flyway migrations executed successfully."

echo "Step 6: Displaying application logs..."
docker logs -f hospital_app