FROM adoptopenjdk/openjdk12:jdk-12.0.2_10-alpine-slim AS builder
WORKDIR /src

COPY *.gradle *.properties gradlew ./
COPY gradle gradle
RUN ./gradlew --version

COPY . .
RUN ./gradlew --no-daemon shadowJar

FROM adoptopenjdk/openjdk12:x86_64-alpine-jre-12.0.2_10
COPY --from=builder /src/build/libs/kmd-booking-*-all.jar kmd-booking.jar
CMD java -Dmicronaut.server.port=${PORT:-8080} -Dcom.sun.management.jmxremote -noverify ${JAVA_OPTS} -jar kmd-booking.jar
