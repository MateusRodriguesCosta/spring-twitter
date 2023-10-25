FROM maven:3.8.4-openjdk-17

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn clean package

RUN mv target/*.jar ./app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]