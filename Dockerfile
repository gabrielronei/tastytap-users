FROM maven:3-amazoncorretto-21 as build

WORKDIR /app

COPY . .

RUN mvn clean package -DskipTests \
    && rm -rf /root/.m2

FROM amazoncorretto:21-alpine

WORKDIR /app

COPY --from=build /app/target/tastytap-users.jar .

CMD ["java", "-jar", "tastytap-users.jar"]
