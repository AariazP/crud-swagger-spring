FROM eclipse-temurin:19
RUN mkdir /app
COPY target/crudRest-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app
CMD ["sh", "-c", "sleep 10 && java -jar crudRest-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
