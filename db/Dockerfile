# Use the latest MySQL image

#MAC
FROM --platform=linux/x86_64 mysql

#Windows
#FROM mysql

# Set the working directory
WORKDIR /tmp
# Copy all the files to the working directory of the container
COPY world-db/*.sql /tmp/
#COPY world_db/*.dump /tmp/ -- not needed!
# Copy the main SQL file to docker-entrypoint-initdb.d.
# Scripts and SQL files in this folder are executed on container startup.
# This is specific to MySQL.
COPY world-db/world.sql /docker-entrypoint-initdb.d
# Set the root password
ENV MYSQL_ROOT_PASSWORD example