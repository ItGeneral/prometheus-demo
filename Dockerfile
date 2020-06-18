ARG MAVENREPO
FROM $MAVENREPO as mavenrepo

WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src/ /build/src/
RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:8
WORKDIR /app
COPY --from=mavenrepo /build/target/prometheus-demo.jar /app

ENTRYPOINT  "java" "-XX:+UseG1GC" "-XX:MaxGCPauseMillis=200" "-Dsun.net.inetaddr.ttl=60" "-jar" "prometheus-demo.jar"