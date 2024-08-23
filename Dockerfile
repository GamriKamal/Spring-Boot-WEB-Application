FROM openjdk:17-oracle
ARG JAR_FILE=target/*.war
COPY ./target/TheMovie-3.1.4.war app.war
#EXPOSE 8089
ENTRYPOINT ["java", "-jar", "/app.war"]