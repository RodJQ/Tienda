
FROM maven:3.8.5-openjdk-17 as build
COPY . .
RUN mvn clean package -DskipTest

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/tienda-1.jar tienda.jar
EXPOSE 80
ENTRYPOINT ["java","-jar","tienda.jar"]

