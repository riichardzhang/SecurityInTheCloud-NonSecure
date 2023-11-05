FROM ubuntu:22.04

WORKDIR /app/

RUN apt-get update
RUN apt-get install -y openjdk-17-jdk

COPY Main.java postgresql-42.6.0.jar /app/

CMD java -cp postgresql-42.6.0.jar Main.java