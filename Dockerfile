FROM openjdk:11
COPY out/production/Snake/ /tmp
WORKDIR /tmp
CMD java field
