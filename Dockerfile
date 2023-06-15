FROM maven:3.8.4-openjdk-11

COPY . /app

WORKDIR /app

RUN mvn clean install

ARG JAR_FILE=target/sarc-api-2.1.5.RELEASE.jar

ENTRYPOINT ["mvn", "clean", "install"]
