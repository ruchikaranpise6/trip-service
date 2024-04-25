FROM openjdk:17-jdk-slim
COPY build/libs/*.jar trip-service.jar
ENTRYPOINT ["java","-jar","trip-service.jar"]