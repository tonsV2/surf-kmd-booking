FROM adoptopenjdk/openjdk11-openj9:jdk-11.0.1.13-alpine-slim AS builder
WORKDIR /src

COPY *.gradle *.properties gradlew ./
COPY gradle gradle
RUN ./gradlew --version

COPY . .
RUN ./gradlew --no-daemon shadowJar

FROM adoptopenjdk/openjdk11-openj9:jdk-11.0.1.13-alpine-slim
COPY --from=builder /src/build/libs/kmd-booking-*-all.jar kmd-booking.jar
CMD java -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar kmd-booking.jar
