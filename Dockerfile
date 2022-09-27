FROM openjdk:17
EXPOSE 8080
ADD target/*.jar exchanger.jar
ENTRYPOINT ["java", "-jar", "/deneme.jar"]
